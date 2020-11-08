package website.skylorbeck.sentimentality2;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.w3c.dom.ranges.Range;

import java.util.concurrent.TimeUnit;

public class ExtraHUD {
    private MinecraftClient client;

    public ExtraHUD() {
        client = MinecraftClient.getInstance();
        HudRenderCallback.EVENT.register((__, ___) -> {
            this.render();
        });
    }
    private void render(){
        final GameOptions gameOptions = client.options;
        final PlayerEntity player = client.player;
        if (player == null) return;
        final World world = client.world;
        BlockPos blockPos = player.getBlockPos();
        int blockLightLevel = world.getLightLevel(LightType.BLOCK,blockPos);
        int lightLevel = world.getLightLevel(blockPos);
        long time = world.getTimeOfDay();
        long worldtime = world.getTime();
        final Inventory inventory = player.inventory;
        final InGameHud inGameHud = client.inGameHud;
        final TextRenderer textRenderer = client.textRenderer;
        final MatrixStack matrixStack = new MatrixStack();
        int scaledWidth = this.client.getWindow().getScaledWidth();
        int scaledHeight = this.client.getWindow().getScaledHeight();
        int color = 0;


        if (time >=24000){
            time = time-(24000*Math.floorDiv(time,24000));
        }
        long hour = Math.floorDiv(time,1000);
        int minute =(int)((time-(hour*1000L))/16.7);
        hour = hour+6;
        if (hour>=24){
            hour = hour-24;
        }
        String clockText = String.format("%02d",hour)+":"+String.format("%02d",minute);
        String compassText =blockPos.getX()+", "+blockPos.getZ();
        if (inventory.count(Items.CLOCK)>=1) {
            textRenderer.drawWithShadow(matrixStack,clockText,scaledWidth/2+95,scaledHeight-20,16777215);
        }
        if(inventory.count(Items.COMPASS)>=1) {
            textRenderer.drawWithShadow(matrixStack,compassText,scaledWidth/2+95,scaledHeight-10,16777215);
        }
        if ((time<23460)&&(time>12377)){
            lightLevel=blockLightLevel;
        }
        String lightText= String.format("%02d",lightLevel);//this is old but if I remove it, the JDE throws a fit about not initializing variables
        if(lightLevel>=12&&lightLevel<=15){
            color = 43520;
            //lightText = "✔";
        }else if(lightLevel>=8&&lightLevel<=11){
            color =16777045;
            //lightText = "✔";
        }else if(lightLevel>=2&&lightLevel<=7){
            color =16733525;
            //lightText = "✘";
        }else if(lightLevel<=1){
            color =11141120;
            //lightText = "✘";
        }
        if(inventory.count(Declarer.personal_daylight_detector)>=1) {
            textRenderer.drawWithShadow(matrixStack,lightText,scaledWidth/2+155,scaledHeight-20,color);
            textRenderer.drawWithShadow(matrixStack,"Light:",scaledWidth/2+125,scaledHeight-20,16777215);
        }
    }
}
