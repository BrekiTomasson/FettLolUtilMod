package net.fettlol.mixin;

import net.fettlol.util.TagHelper;
import net.minecraft.resource.ResourceManager;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagGroupLoader;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(TagGroupLoader.class)
public class TagGroupLoaderMixin {

    @Final
    @Shadow
    private String entryType;

    @Inject(method = "prepareReload", at = @At("RETURN"), cancellable = true)
    public void be_prepareReload(ResourceManager manager, Executor prepareExecutor, CallbackInfoReturnable<CompletableFuture<Map<Identifier, Tag.Builder>>> info) {
        CompletableFuture<Map<Identifier, Tag.Builder>> future = info.getReturnValue();
        info.setReturnValue(CompletableFuture.supplyAsync(() -> {
            Map<Identifier, Tag.Builder> map = future.join();
            TagHelper.apply(entryType, map);
            return map;
        }));
    }
}