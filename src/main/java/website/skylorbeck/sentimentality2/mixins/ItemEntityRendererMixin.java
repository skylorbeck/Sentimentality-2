package website.skylorbeck.sentimentality2.mixins;

import net.minecraft.block.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.sentimentality2.ItemEntityRotator;

import java.util.Random;

@Mixin(ItemEntityRenderer.class)
public abstract class ItemEntityRendererMixin extends EntityRenderer<ItemEntity> {
    @Shadow
    @Final
    private Random random;
    @Shadow
    @Final
    private ItemRenderer itemRenderer;

    @Shadow
    protected abstract int getRenderedAmount(ItemStack stack);

    protected ItemEntityRendererMixin(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Inject(at = @At("RETURN"), method = "<init>")
    private void onConstructor(EntityRenderDispatcher dispatcher, ItemRenderer renderer, CallbackInfo callback) {
        this.shadowRadius = 0.15f;
    }

    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    private void render(ItemEntity itemEntity, float f, float partialTicks, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        ItemStack itemStack = itemEntity.getStack();
        Item item = itemStack.getItem();
        int seed = itemStack.isEmpty() ? 187 : Item.getRawId(item) + itemStack.getDamage();
        this.random.setSeed(seed);
        matrixStack.push();
        BakedModel bakedModel = this.itemRenderer.getHeldItemModel(itemStack, itemEntity.world, null);
        boolean hasDepthInGui = bakedModel.hasDepth();
        int renderCount = this.getRenderedAmount(itemStack);
        boolean flat = false;
        boolean skull = false;
        boolean lantern = false;
        if (item instanceof BlockItem && !(item instanceof AliasedBlockItem)) {
            Block b = ((BlockItem) item).getBlock();
            VoxelShape shape = b.getOutlineShape(b.getDefaultState(), itemEntity.world, itemEntity.getBlockPos(), ShapeContext.absent());
            if (b instanceof TorchBlock
                    || b instanceof WallMountedBlock
                    || b instanceof AbstractPlantPartBlock
                    || b instanceof HopperBlock
                    || b instanceof LadderBlock
                    || b instanceof DoorBlock
                    || b instanceof TripwireHookBlock
                    || b instanceof PlantBlock
                    || b instanceof CobwebBlock
                    || shape.getMax(Direction.Axis.X) <= .25
                    || shape.getMax(Direction.Axis.Y) <= .25
                    || shape.getMax(Direction.Axis.Z) <= .25
            ) {
                flat = true;
            }
            if (b instanceof TrapdoorBlock || b instanceof AbstractPressurePlateBlock || b instanceof SnowBlock) {
                flat = false;
            }
            if (b instanceof SkullBlock) {
                skull = true;
            }
            if (b instanceof LanternBlock) {
                lantern = true;
            }
        }

        matrixStack.multiply(Vector3f.POSITIVE_X.getRadialQuaternion(1.571F));

        ItemEntityRotator rotator = (ItemEntityRotator) itemEntity;
        float rotation = ((float) itemEntity.getAge() + partialTicks) / 10.0F + itemEntity.hoverHeight;
        boolean isAboveWater1 = itemEntity.world.getBlockState(itemEntity.getBlockPos()).getFluidState().getFluid().isIn(FluidTags.WATER);
        if (itemEntity.isSubmergedInWater() || isAboveWater1) {
            rotation = rotation / 4;
            if (rotation / 2 == 0) {
                matrixStack.multiply(Vector3f.POSITIVE_X.getRadialQuaternion(rotation));
                matrixStack.multiply(Vector3f.POSITIVE_Y.getRadialQuaternion(rotation));
                matrixStack.multiply(Vector3f.POSITIVE_Z.getRadialQuaternion(rotation));
                rotator.setRotation(new Vec3d(0, 0, rotation));
            } else {
                matrixStack.multiply(Vector3f.NEGATIVE_X.getRadialQuaternion(rotation));
                matrixStack.multiply(Vector3f.NEGATIVE_Y.getRadialQuaternion(rotation));
                matrixStack.multiply(Vector3f.NEGATIVE_Z.getRadialQuaternion(rotation));
                rotator.setRotation(new Vec3d(0, 0, rotation));
            }
        } else if (!itemEntity.isOnGround() && !itemEntity.isSubmergedInWater()) {
            if (rotation / 2 == 0) {
                matrixStack.multiply(Vector3f.POSITIVE_X.getRadialQuaternion(rotation));
                matrixStack.multiply(Vector3f.POSITIVE_Y.getRadialQuaternion(rotation));
                matrixStack.multiply(Vector3f.POSITIVE_Z.getRadialQuaternion(rotation));
                rotator.setRotation(new Vec3d(0, 0, rotation));
            } else {
                matrixStack.multiply(Vector3f.NEGATIVE_X.getRadialQuaternion(rotation));
                matrixStack.multiply(Vector3f.NEGATIVE_Y.getRadialQuaternion(rotation));
                matrixStack.multiply(Vector3f.NEGATIVE_Z.getRadialQuaternion(rotation));
                rotator.setRotation(new Vec3d(0, 0, rotation));
            }
        } else if (itemEntity.getStack().getItem() instanceof AliasedBlockItem) {
            matrixStack.multiply(Vector3f.POSITIVE_Z.getRadialQuaternion((float) rotator.getRotation().z));
        } else if (itemEntity.getStack().getItem() instanceof BlockItem && !flat) {
            matrixStack.multiply(Vector3f.POSITIVE_X.getRadialQuaternion(300));
            matrixStack.multiply(Vector3f.POSITIVE_Y.getRadialQuaternion((float) rotator.getRotation().z));
            matrixStack.multiply(Vector3f.POSITIVE_Z.getRadialQuaternion(0));
        } else {
            matrixStack.multiply(Vector3f.POSITIVE_Z.getRadialQuaternion((float) rotator.getRotation().z));
            if (itemEntity.world.getBlockState(itemEntity.getBlockPos()).getBlock().equals(Blocks.SNOW)){
                matrixStack.translate(0, 0, -0.12);
            }
        }
        if (item instanceof AliasedBlockItem || flat) {

        } else if (skull||lantern) {
            matrixStack.translate(0, 0.06, 0);
        }else if(itemEntity.getStack().getItem() instanceof BlockItem ) {
            matrixStack.translate(0, -0.06f, 0);
        }
        if(itemEntity.world.getBlockState(itemEntity.getBlockPos()).getBlock().equals(Blocks.SOUL_SAND)) {
            matrixStack.translate(0, 0, -.1);
        }
        float scaleX = bakedModel.getTransformation().ground.scale.getX();
        float scaleY = bakedModel.getTransformation().ground.scale.getY();
        float scaleZ = bakedModel.getTransformation().ground.scale.getZ();

        float x;
        float y;
        if (!hasDepthInGui) {
            float r = -0.0F * (float)(renderCount) * 0.5F * scaleX;
            x = -0.0F * (float)(renderCount) * 0.5F * scaleY;
            y = -0.09375F * (float)(renderCount) * 0.5F * scaleZ;
            matrixStack.translate(r, x, y);
        }
        for(int u = 0; u < renderCount; ++u) {
            matrixStack.push();
            if (u > 0) {
                if (hasDepthInGui) {
                    x = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
                    y = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
                    float z = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
                    matrixStack.translate(x, y, z);
                } else {
                    x = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
                    y = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
                    matrixStack.translate(x, y, 0.0D);
                    matrixStack.multiply(Vector3f.POSITIVE_Z.getRadialQuaternion(this.random.nextFloat()));
                }
            }
            this.itemRenderer.renderItem(itemStack, ModelTransformation.Mode.GROUND, false, matrixStack, vertexConsumerProvider, i, OverlayTexture.DEFAULT_UV, bakedModel);
            matrixStack.pop();
            if (!hasDepthInGui) {
                matrixStack.translate(0.0F * scaleX, 0.0F * scaleY, 0.0625F * scaleZ);
            }
        }

        matrixStack.pop();
        super.render(itemEntity, f, partialTicks, matrixStack, vertexConsumerProvider, i);
        ci.cancel();
    }
}