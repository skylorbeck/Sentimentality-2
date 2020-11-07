package website.skylorbeck.sentimentality2;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public interface ItemEntityRotator {
    Vec3d getRotation();
    void setRotation(Vec3d rotation);
}