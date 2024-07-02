package com.kryeit.kryeitdrip.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.network.packet.s2c.play.PlayerListS2CPacket;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;

import java.io.InputStream;
import java.util.Base64;
import java.util.UUID;

import net.minecraft.util.Identifier;


public class SkinUtil {
    public static void applyClothingOverlay(ServerPlayerEntity player, String clotheName) {
        GameProfile profile = player.getGameProfile();

        String textureBase64 = getClothingTextureBase64(clotheName);
        System.out.println(textureBase64);
        if (textureBase64 != null) {
            Property textureProperty = new Property("textures", textureBase64);
            profile.getProperties().put("textures", textureProperty);

            // Update the player's appearance
            player.networkHandler.sendPacket(new PlayerListS2CPacket(PlayerListS2CPacket.Action.UPDATE_LISTED, player));
            player.networkHandler.sendPacket(new EntitySpawnS2CPacket(player));
        }
    }

    private static String getClothingTextureBase64(String clotheName) {
        try {
            Identifier textureLocation = new Identifier("kryeitdrip", "textures/clothes/" + clotheName + ".png");
            InputStream stream = SkinUtil.class.getClassLoader().getResourceAsStream("assets/kryeitdrip/" + textureLocation.getPath());
            if (stream != null) {
                byte[] bytes = stream.readAllBytes();
                stream.close();
                return Base64.getEncoder().encodeToString(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
