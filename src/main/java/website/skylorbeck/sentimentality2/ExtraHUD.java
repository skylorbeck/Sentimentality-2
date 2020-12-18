package website.skylorbeck.sentimentality2;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

import java.time.LocalTime;
import java.util.List;

public class ExtraHUD {
    private MinecraftClient client;

    public ExtraHUD() {
        client = MinecraftClient.getInstance();
        HudRenderCallback.EVENT.register((__, ___) -> {
            this.render();
        });
    }


    private void render() {
        boolean military = Registrar.getConfig().clockStuff.clockMilitary;
        boolean doAmPm = Registrar.getConfig().clockStuff.clockAmPm;
        boolean showSleepCount = Registrar.getConfig().showSleepCount;
        boolean showItems = Registrar.getConfig().showItems;
        int clockCorner = Registrar.getConfig().clockStuff.clockCorner;

        final PlayerEntity player = client.player;
        if (player == null) return;
        final World world = client.world;
        long time = world.getTimeOfDay();
        final Inventory inventory = player.inventory;
        final TextRenderer textRenderer = client.textRenderer;
        final ItemRenderer itemRenderer = client.getItemRenderer();
        final MatrixStack matrixStack = new MatrixStack();
        int scaledWidth = this.client.getWindow().getScaledWidth();
        int scaledHeight = this.client.getWindow().getScaledHeight();
        int color;
        int slotsUsed = 0;
        int localHour = LocalTime.now().getHour();
        int localMinute = LocalTime.now().getMinute();
        String amPm = "AM";
        boolean left = false;
        if (client.options.mainArm == Arm.LEFT){left = true;}


        if (time >= 24000) {
            time = time - (24000 * Math.floorDiv(time, 24000));
        }
        //settings
        boolean isNight = (time < 23460) && (time > 12377);

        if(showItems) {
            for (int i = 9; i < 36; i++) {
                ItemStack stack = inventory.getStack(i);
                Item item = stack.getItem();
                if (item == Items.CLOCK
                        || item == Items.COMPASS
                        || item == Declarer.personal_daylight_detector
                        || item == Declarer.slime_chunk_locator
                ) {
                    if (left) {
                        itemRenderer.renderInGuiWithOverrides(inventory.getStack(i), scaledWidth / 2 - (109 + (15 * slotsUsed)), scaledHeight - 19);
                    } else {
                        itemRenderer.renderInGuiWithOverrides(inventory.getStack(i), scaledWidth / 2 + (92 + (15 * slotsUsed)), scaledHeight - 19);
                    }
                    slotsUsed++;
                }
            }
        }

        int sleeping = 0;
        List playerEntities = world.getPlayers();
        for (int i = 0; i < playerEntities.size(); i++) {
            if (world.getPlayers().get(i).isSleeping()) {
                sleeping++;
            }
        }
        if (sleeping >= 1 && showSleepCount) {
            int sleepAdj = 0;
            if(clockCorner == 2){
                sleepAdj = 8;
            } else {
                sleepAdj = 0;
            }
            itemRenderer.renderInGui(new ItemStack(Items.RED_BED), 0, scaledHeight - 18 - sleepAdj);
            if (sleeping * 100 / playerEntities.size() >= SleepEventManager.percent) {
                color = 43520;
            } else {
                color = 16733525;
            }
            int total = playerEntities.size();
            textRenderer.drawWithShadow(matrixStack, sleeping + "/" + total, 20, scaledHeight - 10 - sleepAdj, color);
        }
        if (localHour >=12){
             amPm = "PM";
        }
        if (!military && localHour >= 13) {
            localHour = localHour - 12;
        }
        int clockPosX = 0;
        int clockPosY = 0;
        int clockAdj = 0;
        switch (clockCorner){
            case 0:
                clockPosX = 1;
                clockPosY = 1;
                clockAdj = 0;
                break;
            case 1:
                clockPosX = scaledWidth - 38;
                clockPosY = 1;
                clockAdj = -12;
                break;
            case 2:
                clockPosX = 1;
                clockPosY = scaledHeight-8;
                clockAdj = 0;
                break;
            case 3:
                clockPosX = scaledWidth - 38;
                clockPosY = scaledHeight-8;
                clockAdj = -12;
                break;
        }

        if (doAmPm && !military) {
            textRenderer.drawWithShadow(matrixStack, String.format("%02d", localHour) + ":" + String.format("%02d", localMinute)+amPm, clockPosX, clockPosY, 16777215);
        } else {
            textRenderer.drawWithShadow(matrixStack, String.format("%02d", localHour) + ":" + String.format("%02d", localMinute), clockPosX-clockAdj, clockPosY, 16777215);
        }
    }
}