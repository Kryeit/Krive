package com.kryeit.kryeitdrip;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.minecraft.util.Identifier;

public class KryeitDrip implements DedicatedServerModInitializer {

    public static final String MOD_ID = "kryeitdrip";

    @Override
    public void onInitializeServer() {

    }

    public static Identifier asResource(String path) {
        return new Identifier(MOD_ID, path);
    }
}
