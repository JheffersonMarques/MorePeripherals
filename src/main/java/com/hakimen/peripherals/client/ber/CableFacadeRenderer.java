package com.hakimen.peripherals.client.ber;

import com.hakimen.peripherals.utils.NBTUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import dan200.computercraft.shared.peripheral.modem.wired.CableBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;

public class CableFacadeRenderer implements BlockEntityRenderer<CableBlockEntity> {

    BlockEntityRendererProvider.Context context;
    public CableFacadeRenderer(BlockEntityRendererProvider.Context context) {
        this.context = context;
    }

    @Override
    public void render(CableBlockEntity cable, float partialTicks, PoseStack stack, MultiBufferSource buffer, int overlay, int packedLight) {
        var data = cable.saveWithFullMetadata();
        if(data.contains("facade")){
            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(
                    NBTUtils.readBlockState(data.getCompound("facade")),
                    stack,
                    buffer,
                    overlay,
                    packedLight
            );
        }
    }

    @Override
    public boolean shouldRender(CableBlockEntity p_173568_, Vec3 p_173569_) {
        return true;
    }

}
