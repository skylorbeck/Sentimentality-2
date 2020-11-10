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
        BlockPos blockPos = player.getBlockPos();
        int lightLevel = world.getLightLevel(blockPos);
        long time = world.getTimeOfDay();
        final Inventory inventory = player.inventory;
        final TextRenderer textRenderer = client.textRenderer;
        final ItemRenderer itemRenderer = client.getItemRenderer();
        final MatrixStack matrixStack = new MatrixStack();
        int scaledWidth = this.client.getWindow().getScaledWidth();
        int scaledHeight = this.client.getWindow().getScaledHeight();
        int color = 0;
        int slotsUsed = 0;


        if (time >= 24000) {
            time = time - (24000 * Math.floorDiv(time, 24000));
        }
        long hour = Math.floorDiv(time, 1000);
        int minute = (int) ((time - (hour * 1000L)) / 16.7);
        hour = hour + 6;
        if (hour >= 24) {
            hour = hour - 24;
        }
        if (inventory.count(Items.CLOCK) >= 1) {
            if (!clockIcon) {
                String clockText = String.format("%02d", hour) + ":" + String.format("%02d", minute);
                textRenderer.drawWithShadow(matrixStack, clockText, scaledWidth / 2 + 95, scaledHeight - 20, 16777215);
            } else {
                for (int i = 9; i < 36; i++) {
                    ItemStack stack = inventory.getStack(i);
                    if (stack.getItem() == Items.CLOCK) {
                        itemRenderer.renderInGuiWithOverrides(inventory.getStack(i), scaledWidth / 2 + 92+(15*slotsUsed), scaledHeight - 19);
                        slotsUsed++;
                    }
                }
            }
        }

        String compassText = blockPos.getX() + ", " + blockPos.getZ();
        if (inventory.count(Items.COMPASS) >= 1) {
            if (!compassIcon) {
                textRenderer.drawWithShadow(matrixStack, compassText, scaledWidth / 2 + 95, scaledHeight - 10, 16777215);
            } else {
                for (int i = 9; i < 36; i++) {
                    ItemStack stack = inventory.getStack(i);
                    if (stack.getItem() == Items.COMPASS) {
                        itemRenderer.renderInGuiWithOverrides(inventory.getStack(i), scaledWidth / 2 + 92+(15*slotsUsed), scaledHeight - 19);
                        slotsUsed++;
                    }
                }
            }
        }

        //lightLevel = blockLightLevel;
        isNight = (time < 23460) && (time > 12377);
        String lightText;
        if (!lightCheck) {
            lightText = String.format("%02d", lightLevel);
        } else {
            if (lightLevel >= 12) {
                lightText = "✔";
            } else {
                lightText = "✘";
            }
        }

        if (lightLevel >= 12 && lightLevel <= 15) {
            color = 43520;
        } else if (lightLevel >= 8 && lightLevel <= 11) {
            color = 16777045;
        } else if (lightLevel >= 2 && lightLevel <= 7) {
            color = 16733525;
        } else if (lightLevel <= 1) {
            color = 11141120;
        }
        if (inventory.count(Declarer.personal_daylight_detector) >= 1) {
            if (!PDDIcon) {
                textRenderer.drawWithShadow(matrixStack, lightText, scaledWidth / 2 + 155, scaledHeight - 20, color);
                textRenderer.drawWithShadow(matrixStack, "Light:", scaledWidth / 2 + 125, scaledHeight - 20, 16777215);
            } else {
                for (int i = 9; i < 36; i++) {
                    ItemStack stack = inventory.getStack(i);
                    if (stack.getItem() == Declarer.personal_daylight_detector) {
                        itemRenderer.renderInGuiWithOverrides(inventory.getStack(i), scaledWidth / 2 + 92+(15*slotsUsed), scaledHeight - 19);
                        slotsUsed++;
                    }
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