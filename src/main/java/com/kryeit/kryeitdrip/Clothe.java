package com.kryeit.kryeitdrip;

import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

public class Clothe extends ElementHolder {
    private final ItemStack item;
    private final String permission;
    private final String name;

    public Clothe(ItemStack item, String permission, String name) {
        this.item = item;
        this.permission = permission;
        this.name = name;
    }

    public ItemStack getItem() {
        return item;
    }

    public String getPermission() {
        return permission;
    }

    public String getName() {
        return name;
    }

    public static Clothe hoodie() {
        ItemStack hoodie = new ItemStack(Items.LEATHER_CHESTPLATE)
                .setCustomName(Text.of("Kryeit hoodie"));
        hoodie.addHideFlag(ItemStack.TooltipSection.MODIFIERS);

        if (hoodie.getItem() instanceof DyeableArmorItem) {
            ((DyeableArmorItem) hoodie.getItem()).setColor(hoodie, 0xFFFFFF);
        }

        return new Clothe(hoodie, "kryeitdrip.hoodie", "hoodie");
    }
}
