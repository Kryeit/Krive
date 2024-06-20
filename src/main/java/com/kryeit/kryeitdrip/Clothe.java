package com.kryeit.kryeitdrip;

import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

public class Clothe {
    private final ItemStack item;
    private final String permission;

    public Clothe(ItemStack item, String permission) {
        this.item = item;
        this.permission = permission;
    }

    public ItemStack getItem() {
        return item;
    }

    public String getPermission() {
        return permission;
    }

    public static Clothe hoodie() {
        ItemStack hoodie = new ItemStack(Items.LEATHER_CHESTPLATE)
                .setCustomName(Text.of("Kryeit hoodie"));
        hoodie.addHideFlag(ItemStack.TooltipSection.MODIFIERS);

        if (hoodie.getItem() instanceof DyeableArmorItem) {
            ((DyeableArmorItem) hoodie.getItem()).setColor(hoodie, 0xFFFFFF);
        }

        return new Clothe(hoodie, "kryeitdrip.hoodie");
    }
}
