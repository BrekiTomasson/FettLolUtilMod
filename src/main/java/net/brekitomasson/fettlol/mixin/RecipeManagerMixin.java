package net.brekitomasson.fettlol.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.brekitomasson.fettlol.integration.BetterEnd;
import net.brekitomasson.fettlol.integration.BiomesYoullGo;
import net.brekitomasson.fettlol.util.RegistryHelper;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

    @Inject(method = "apply", at = @At("HEAD"))
    public void applyFettLolCustomRecipes(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci) {
        // Recipes related to: Biomes You'll Go, Armor & Tools
        addCustomRecipe(map, "byg/ametrine_boots", BiomesYoullGo.AMETRINE_BOOTS_RECIPE);
        addCustomRecipe(map, "byg/ametrine_chestplate", BiomesYoullGo.AMETRINE_CHESTPLATE_RECIPE);
        addCustomRecipe(map, "byg/ametrine_helmet", BiomesYoullGo.AMETRINE_HELMET_RECIPE);
        addCustomRecipe(map, "byg/ametrine_leggings", BiomesYoullGo.AMETRINE_LEGGINGS_RECIPE);
        addCustomRecipe(map, "byg/pendorite_axe", BiomesYoullGo.PENDORITE_AXE_RECIPE);
        addCustomRecipe(map, "byg/pendorite_hoe", BiomesYoullGo.PENDORITE_HOE_RECIPE);
        addCustomRecipe(map, "byg/pendorite_pickaxe", BiomesYoullGo.PENDORITE_PICKAXE_RECIPE);
        addCustomRecipe(map, "byg/pendorite_shovel", BiomesYoullGo.PENDORITE_SHOVEL_RECIPE);
        addCustomRecipe(map, "byg/pendorite_sword", BiomesYoullGo.PENDORITE_SWORD_RECIPE);

        // Recipes related to: Biomes You'll Go, Other.
        addCustomRecipe(map, "byg/black_sandstone", BiomesYoullGo.BLACK_SANDSTONE_RECIPE);
        addCustomRecipe(map, "byg/black_stained_glass", BiomesYoullGo.BLACK_GLASS_RECIPE);

        // Recipes related to: Better End, Armor & Tools
        addCustomRecipe(map, "betterend/aeternium_axe", BetterEnd.AETERNIUM_AXE_RECIPE);
        addCustomRecipe(map, "betterend/aeternium_boots", BetterEnd.AETERNIUM_BOOTS_RECIPE);
        addCustomRecipe(map, "betterend/aeternium_chestplate", BetterEnd.AETERNIUM_CHESTPLATE_RECIPE);
        addCustomRecipe(map, "betterend/aeternium_helmet", BetterEnd.AETERNIUM_HELMET_RECIPE);
        addCustomRecipe(map, "betterend/aeternium_hoe", BetterEnd.AETERNIUM_HOE_RECIPE);
        addCustomRecipe(map, "betterend/aeternium_leggings", BetterEnd.AETERNIUM_LEGGINGS_RECIPE);
        addCustomRecipe(map, "betterend/aeternium_pickaxe", BetterEnd.AETERNIUM_PICKAXE_RECIPE);
        addCustomRecipe(map, "betterend/aeternium_shovel", BetterEnd.AETERNIUM_SHOVEL_RECIPE);
        addCustomRecipe(map, "betterend/aeternium_sword", BetterEnd.AETERNIUM_SWORD_RECIPE);

        // Recipes related to: Better End, Ingots
        addCustomRecipe(map, "betterend/aeternium_ingot", BetterEnd.AETERNIUM_INGOT_RECIPE);
        addCustomRecipe(map, "betterend/terminite_ingot", BetterEnd.TERMINITE_INGOT_RECIPE);
    }

    private void addCustomRecipe(Map<Identifier, JsonElement> map, String recipeName, JsonObject definition) {
        if (definition != null) {
            map.put(RegistryHelper.makeId(recipeName), definition);
        }
    }

}
