package net.fettlol.items;

import net.fettlol.items.base.BasicItem;
import net.minecraft.util.Rarity;

public class WitherBone extends BasicItem {

    public WitherBone() {
        super(new Settings().maxCount(64).rarity(Rarity.UNCOMMON).fireproof());
    }
}
