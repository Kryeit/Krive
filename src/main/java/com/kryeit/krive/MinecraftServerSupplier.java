package com.kryeit.krive;

import net.minecraft.server.MinecraftServer;

public class MinecraftServerSupplier {
    private static MinecraftServer server;

    public static MinecraftServer getServer() {
        return server;
    }

    public static void setServer(MinecraftServer server) {
        MinecraftServerSupplier.server = server;
    }
}