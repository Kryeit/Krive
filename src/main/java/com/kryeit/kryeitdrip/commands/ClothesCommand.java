package com.kryeit.kryeitdrip.commands;

import com.kryeit.kryeitdrip.gui.ClothesGUI;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import eu.pb4.sgui.api.gui.SimpleGui;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.function.Supplier;

public class ClothesCommand {
    public static int execute(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
        ServerPlayerEntity player = source.getPlayer();

        if (player == null) {
            Supplier<Text> message = () -> Text.of("Can't execute from console");
            source.sendFeedback(message, false);
            return 0;
        }

        new ClothesGUI(player);

        return Command.SINGLE_SUCCESS;
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("clothes")
                .executes(ClothesCommand::execute)
        );
    }
}
