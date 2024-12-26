package com.kryeit.krive.polydex;

import net.minecraft.text.Text;

import static com.kryeit.krive.ui.UiResourceCreator.polydexBackground;

public class PolydexTextures {
    public static final Text WARDROBE;

    public static void register() {}

    static {
        var wardrobe = polydexBackground("wardrobe");
        WARDROBE = wardrobe.getLeft();
    }
}
