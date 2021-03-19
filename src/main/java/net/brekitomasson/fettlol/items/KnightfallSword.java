package net.brekitomasson.fettlol.items;

import net.brekitomasson.fettlol.UtilMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.List;

public class KnightfallSword extends SwordItem {

    public KnightfallSword() {
        super(
            ToolMaterials.NETHERITE,
            5,
            -2.5F,
            new Settings().group(UtilMod.ITEMGROUP).fireproof().rarity(Rarity.RARE)
        );
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.fettlol.knightfall.tooltip"));
    }

}
