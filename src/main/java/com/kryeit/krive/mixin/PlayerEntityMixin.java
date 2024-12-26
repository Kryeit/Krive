package com.kryeit.krive.mixin;

import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.attachment.EntityAttachment;
import eu.pb4.polymer.virtualentity.api.elements.MarkerElement;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerPlayerEntity.class)
public class PlayerEntityMixin {

    @Unique
    private ElementHolder holder;

    @Unique
    private MarkerElement skin;

    @Unique
    private MarkerElement hat;

    @Unique
    private MarkerElement hoodie;

    @Unique
    private MarkerElement pants;

    @Unique
    private MarkerElement shoes;

    @Unique
    private Pair<MarkerElement, MarkerElement> hands;


    @Inject(method = "<init>*", at = @At("RETURN"))
    private void onInit(CallbackInfo info) {
        ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
        holder = new ElementHolder();

        List<MarkerElement> clothes = List.of(skin, hat, hoodie, pants, shoes, hands.getLeft(), hands.getRight());

        for (MarkerElement clothe : clothes) {
            if (clothe == null) continue;
            holder.addElement(clothe);
        }

        EntityAttachment.ofTicking(holder, player);
    }
}
