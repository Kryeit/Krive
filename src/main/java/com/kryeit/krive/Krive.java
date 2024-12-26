package com.kryeit.krive;

import com.kryeit.krive.commands.WardrobeCommand;
import com.kryeit.krive.ui.GuiTextures;
import com.kryeit.krive.ui.UiResourceCreator;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class Krive implements ModInitializer {

    public static final String ID = "krive";
    public static final boolean DEV = FabricLoader.getInstance().isDevelopmentEnvironment();
    @SuppressWarnings("PointlessBooleanExpression")
    public static final boolean DYNAMIC_ASSETS = true && DEV;
    @Override
    public void onInitialize() {
        registerCommands();

        UiResourceCreator.setup();
        GuiTextures.register();

        // Resource pack
        PolymerResourcePackUtils.addModAssets(ID);
        PolymerResourcePackUtils.markAsRequired();
    }

    public void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicatedServer, commandFunction) -> {
            WardrobeCommand.register(dispatcher);
        });
    }

    public static Identifier asResource(String path) {
        return new Identifier(ID, path);
    }
}
