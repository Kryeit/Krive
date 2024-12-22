package com.kryeit.kryeitdrip.ui;

import com.kryeit.kryeitdrip.KryeitDrip;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UiResourceCreator {
    public static final Style STYLE = Style.EMPTY.withColor(0xFFFFFF).withFont(KryeitDrip.asResource("gui"));
    private static final List<FontTexture> FONT_TEXTURES = new ArrayList<>();

    private static char character = 'a';

    private static final char CHEST_SPACE0 = character++;
    private static final char CHEST_SPACE1 = character++;

    public static Function<Text, Text> background(String path) {
        var builder = new StringBuilder().append(CHEST_SPACE0);
        var c = (character++);
        builder.append(c);
        builder.append(CHEST_SPACE1);

        var texture = new FontTexture(KryeitDrip.asResource("sgui/" + path), 13, 256, new char[][] { new char[] {c} });

        FONT_TEXTURES.add(texture);
        return new TextBuilders(Text.literal(builder.toString()).setStyle(STYLE));
    }

    private record TextBuilders(Text base) implements Function<Text, Text> {
        @Override
        public Text apply(Text text) {
            return Text.empty().append(base).append(text);
        }
    }

    public record FontTexture(Identifier path, int ascent, int height, char[][] chars) {};
}
