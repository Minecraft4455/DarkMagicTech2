package mods.me.minecraft4455.dmt2.core;

import net.minecraftforge.common.MinecraftForge;
import mods.me.minecraft4455.dmt2.core.model.ModelDressedZombie;
import mods.me.minecraft4455.dmt2.core.render.RenderDressedZombie;
import mods.me.minecraft4455.dmt2.entity.EntityDressedZombie;
import mods.me.minecraft4455.dmt2.handler.SoundHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
    @Override
    public void registerRenderThings() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDressedZombie.class, new RenderDressedZombie(new ModelDressedZombie(), 0.3F));
    }
    @Override
    public void registerSoundHandler() {
        MinecraftForge.EVENT_BUS.register(new SoundHandler());
    }
}
