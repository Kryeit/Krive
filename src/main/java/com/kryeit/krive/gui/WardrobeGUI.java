package com.kryeit.krive.gui;

import com.kryeit.krive.ui.GuiTextures;
import com.kryeit.krive.ui.GuiUtils;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class WardrobeGUI extends SimpleGui {

    private int page = 0;

    public WardrobeGUI(ServerPlayerEntity player) {
        super(ScreenHandlerType.GENERIC_9X6, player, false);
        this.setTitle(GuiTextures.WARDROBE.apply(Text.literal("Wardrobe")));

        this.setSlot(51, GuiTextures.PREVIOUS_BUTTON.get().unbreakable().setCallback((clickType) -> {
            GuiUtils.playClickSound(player);
            previousPage();
        }).setName(Text.literal("Previous page")));

        this.setSlot(53, GuiTextures.NEXT_BUTTON.get().unbreakable().setCallback((clickType) -> {
            GuiUtils.playClickSound(player);
            nextPage();
        }).setName(Text.literal("Next page")));

        this.open();
    }

    private void updateNumbers() {
        GuiUtils.drawFlatNumbers(this, 52, page + 1, 1, 0x888888, false);
    }

    @Override
    public void onTick() {
        updateNumbers();
        super.onTick();
    }


    /*
     * PAGINATION
     */
    private void previousPage() {
        if (page > 0) {
            page--;
        }
    }

    private void nextPage() {
        if (page < 9 - 1) {
            page++;
        }
    }

}
