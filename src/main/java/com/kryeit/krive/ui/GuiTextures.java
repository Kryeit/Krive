/* Code copied from Polyfactory by Patbox
 * https://github.com/Patbox/PolyFactory
 *
 * Learn more about his mods: https://pb4.eu
 */

package com.kryeit.krive.ui;

import eu.pb4.sgui.api.elements.GuiElementBuilder;
import net.minecraft.text.Text;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

import static com.kryeit.krive.ui.UiResourceCreator.*;

public class GuiTextures {

    public static final Function<Text, Text> WARDROBE = background("wardrobe");

    public static final Supplier<GuiElementBuilder> PREVIOUS_BUTTON = icon32("button/previous");
    public static final Supplier<GuiElementBuilder> NEXT_BUTTON = icon32("button/next");

    public static final IntFunction<GuiElementBuilder>[] NUMBERS_FLAT = createNumbers("flat/");
    public static final IntFunction<GuiElementBuilder>[] NUMBERS_SHADOW = createNumbers("shadow/");

    public static void register() {

    }

}
