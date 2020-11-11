package website.skylorbeck.sentimentality2;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ExtraHUD {
    private MinecraftClient client;
    private boolean clockIcon = true;
    private boolean compassIcon = true;
    private boolean PDDIcon = true;
    private boolean lightCheck = true;

    private boolean isNight = false;

    public ExtraHUD() {
        client = MinecraftClient.getInstance();
        HudRenderCallback.EVENT.register((__, ___) -> {
            this.render();
        });
    }

    private void render() {
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


        if (time >= 24000) {
            time = time - (24000 * Math.floorDiv(time, 24000));
        }
        isNight = (time < 23460) && (time > 12377);

        for (int i = 9; i < 36; i++) {
            ItemStack stack = inventory.getStack(i);
            Item item = stack.getItem();
            if (item == Items.CLOCK
                    || item == Items.COMPASS
                    || item == Declarer.personal_daylight_detector
                    || item == Declarer.slime_chunk_locater
            ) {
                itemRenderer.renderInGuiWithOverrides(inventory.getStack(i), scaledWidth / 2 + 92 + (15 * slotsUsed), scaledHeight - 19);
                slotsUsed++;
            }
        }

        int sleeping = 0;
        List playerEntities = world.getPlayers();
        for (int i = 0; i < playerEntities.size(); i++) {
            if (world.getPlayers().get(i).isSleeping()) {
                sleeping++;
            }
        }
        if (sleeping >= 1) {
            itemRenderer.renderInGui(new ItemStack(Items.RED_BED), 0, scaledHeight - 18);
            if (sleeping * 100 / playerEntities.size() >= SleepEventManager.percent) {
                color = 43520;
            } else {
                color = 16733525;
            }
            int total = playerEntities.size();
            textRenderer.drawWithShadow(matrixStack, sleeping + "/" + total, 20, scaledHeight - 10, color);
        }
    }
}