package com.kryeit.kryeitdrip.gui;

import com.kryeit.kryeitdrip.Clothe;
import com.kryeit.kryeitdrip.ClotheManager;
import com.kryeit.kryeitdrip.ui.GuiTextures;
import eu.pb4.sgui.api.ClickType;
import eu.pb4.sgui.api.elements.GuiElementInterface;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class WardrobeGUI extends SimpleGui {

    public WardrobeGUI(ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X3, player, false);
        this.setTitle(GuiTextures.WARDROBE.apply(Text.literal("Merch clothes!")));

        for (Clothe clothes : ClotheManager.getInstance().getClothesList()) {
            this.addSlot(clothes.getItem());
        }

        this.open();
    }

    @Override
    public boolean onClick(int index, ClickType type, SlotActionType action, GuiElementInterface element) {
        Clothe clothe = ClotheManager.getInstance().getClothesList().get(index);

        System.out.println("Equipping");
        ClotheManager.getInstance().equipClothe(player, clothe);

        return false;
    }

}
