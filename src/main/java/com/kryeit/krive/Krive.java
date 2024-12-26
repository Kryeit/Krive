package com.kryeit.krive;

import com.kryeit.krive.commands.WardrobeCommand;
import com.kryeit.krive.ui.GuiTextures;
import com.kryeit.krive.ui.UiResourceCreator;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.util.Identifier;

public class Krive implements DedicatedServerModInitializer {

    public static final String MOD_ID = "krive";
    public static final boolean PRODUCTION = true;

    @Override
    public void onInitializeServer() {
        registerCommands();

        UiResourceCreator.setup();
        GuiTextures.register();

        // Resource pack
        PolymerResourcePackUtils.addModAssets(MOD_ID);
        PolymerResourcePackUtils.markAsRequired();
    }

    public void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicatedServer, commandFunction) -> {
            WardrobeCommand.register(dispatcher);
        });
    }

    public static Identifier asResource(String path) {
        return new Identifier(MOD_ID, path);
    }
}
