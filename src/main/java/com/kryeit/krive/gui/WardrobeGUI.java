package com.kryeit.krive.gui;

import com.kryeit.krive.ui.GuiTextures;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class WardrobeGUI extends SimpleGui {


    public WardrobeGUI(ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X6, player, false);
        this.setTitle(GuiTextures.WARDROBE.apply(Text.literal("Wardrobe")));

        this.setSlot(51, GuiTextures.PREVIOUS_BUTTON.get().unbreakable().setCallback((clickType) -> {
            System.out.println("Previous Page");
        }).setName(Text.literal("Previous page")));
        this.setSlot(53, GuiTextures.NEXT_BUTTON.get().unbreakable().setCallback((clickType) -> {
            System.out.println("Next Page");
        }).setName(Text.literal("Next page")));

        this.open();
    }

//    @Override
//    public boolean onClick(int index, ClickType type, SlotActionType action, GuiElementInterface element) {
//        Clothe clothe = ClotheManager.getInstance().getClothesList().get(index);
//
//        System.out.println("Equipping");
//        ClotheManager.getInstance().equipClothe(player, clothe);
//
//        return false;
//    }

}
