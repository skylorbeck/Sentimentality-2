package website.skylorbeck.sentimentality2;

import net.minecraft.util.math.Vec3d;

//@Environment(EnvType.CLIENT)
public interface ItemEntityRotator {
    Vec3d getRotation();
    void setRotation(Vec3d rotation);

}