package com.kryeit.kryeitdrip.gui;

import com.kryeit.kryeitdrip.Clothe;
import com.kryeit.kryeitdrip.ClothesManager;
import eu.pb4.sgui.api.ClickType;
import eu.pb4.sgui.api.elements.GuiElementInterface;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.ApiStatus;

public class ClothesGUI extends SimpleGui {

    public ClothesGUI(ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X1, player, false);
        this.setTitle(Text.literal("Merch clothes!"));

        for (Clothe clothes : ClothesManager.getInstance().getClothesList()) {
            this.addSlot(clothes.getItem());
        }

        this.open();
    }

    @Override
    public boolean onClick(int index, ClickType type, SlotActionType action, GuiElementInterface element) {
        System.out.println("Clicked on index: " + index + " with type: " + type + " and action: " + action);
        return false;
    }

}
