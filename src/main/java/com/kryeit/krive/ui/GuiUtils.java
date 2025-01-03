/* Code copied from Polyfactory by Patbox
 * https://github.com/Patbox/PolyFactory
 *
 * Learn more about his mods: https://pb4.eu
 */
package com.kryeit.krive.ui;

import eu.pb4.sgui.api.elements.GuiElement;
import eu.pb4.sgui.api.elements.GuiElementBuilder;
import eu.pb4.sgui.api.gui.SlotGuiInterface;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.function.IntFunction;

public class GuiUtils {
    public static final GuiElement EMPTY = GuiElement.EMPTY;

    public static final void playClickSound(ServerPlayerEntity player) {
        player.playSound(SoundEvents.UI_BUTTON_CLICK.value(), SoundCategory.MASTER, 0.5f, 1);
    }

    public static void drawFlatNumbers(SlotGuiInterface gui, int position, int value, int size, int color, boolean leadingZero) {
        drawNumberInternal(gui, position, value, size, color, leadingZero, GuiTextures.NUMBERS_FLAT);
    }

    public static void drawShadowNumbers(SlotGuiInterface gui, int position, int value, int size, int color, boolean leadingZero) {
        drawNumberInternal(gui, position, value, size, color, leadingZero, GuiTextures.NUMBERS_SHADOW);
    }

    private static void drawNumberInternal(SlotGuiInterface gui, int position, int value, int size, int color, boolean leadingZero, IntFunction<GuiElementBuilder>[] numbers) {
        for (int i = size - 1; i >= 0; i--)  {
            if (!leadingZero && value == 0 && i != size -1) {
                gui.setSlot(position + i, EMPTY);
                continue;
            }
            var number = value % 10;
            value /= 10;
            gui.setSlot(position + i,  numbers[Math.abs(number)].apply(color));
        }
    }
}
