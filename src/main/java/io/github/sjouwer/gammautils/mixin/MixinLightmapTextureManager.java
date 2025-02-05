package io.github.sjouwer.gammautils.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.sjouwer.gammautils.GammaManager;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LightmapTextureManager.class)
abstract class MixinLightmapTextureManager {

    /**
     * Mixin needed to allow negative gamma
     */
    @ModifyExpressionValue(method = "update", at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(FF)F", ordinal = 2))
    private float allowNegativeGamma(float original) {
        float gamma = (float) GammaManager.getGamma();
        if (gamma < 0) {
            return gamma;
        }

        return original;
    }
}
