package com.kryeit.krive.ui;

import com.kryeit.krive.polydex.PolydexTextures;
import net.minecraft.text.Text;

import java.util.function.Function;

import static com.kryeit.krive.ui.UiResourceCreator.background;

public class GuiTextures {

    public static final Function<Text, Text> WARDROBE = background("wardrobe");

    public static void register() {
        PolydexTextures.register();
    }

}
