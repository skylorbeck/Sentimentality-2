package website.skylorbeck.sentimentality2.mixins;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({PlayerListHud.class})
public abstract class PingIndicator extends DrawableHelper {
    /**
     * @author SkylorBeck
     * @reason I wanted to clarify user ping
     */
    @Overwrite
    public void renderLatencyIcon(MatrixStack matrixStack, int i, int j, int k, PlayerListEntry playerListEntry) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        int ping = playerListEntry.getLatency();
        int rgb;
        if (ping < 0) {
            rgb = 255;
        } else if (ping < 50) {
            rgb = 65280;
        } else if (ping < 100) {
            rgb = 43520;
        } else if (ping < 200) {
            rgb = 16776960;
        } else if (ping < 300) {
            rgb = 16711680;
        } else {
            rgb = 11141120;
        }

        String pingString = this.toSubscriptNumbers(Integer.toString(ping));
        this.setZOffset(this.getZOffset() + 100);
        DrawableHelper.drawCenteredString(matrixStack, MinecraftClient.getInstance().textRenderer, pingString, j + i - 11, k - 1, rgb);
        this.setZOffset(this.getZOffset() - 100);
    }

    private String toSubscriptNumbers(String string) {
        char[] chars = string.toCharArray();

        for(int i = 0; i < chars.length; ++i) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                chars[i] = (char)(chars[i] + 8272);
            } else if (chars[i] == '-') {
                chars[i] = 8320;
            }
        }

        return new String(chars);
    }
}
