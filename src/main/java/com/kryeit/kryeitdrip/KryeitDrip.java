package com.kryeit.kryeitdrip;

import com.kryeit.kryeitdrip.commands.ClothesCommand;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.util.Identifier;

public class KryeitDrip implements DedicatedServerModInitializer {

    public static final String MOD_ID = "kryeitdrip";

    @Override
    public void onInitializeServer() {
        registerCommands();
    }

    public void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicatedServer, commandFunction) -> {
            ClothesCommand.register(dispatcher);
        });
    }

    public static Identifier asResource(String path) {
        return new Identifier(MOD_ID, path);
    }
}
