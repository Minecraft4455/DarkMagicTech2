package mods.me.minecraft4455.dmt2.core.render;

import mods.me.minecraft4455.dmt2.core.model.ModelDressedZombie;
import mods.me.minecraft4455.dmt2.entity.EntityDressedZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderDressedZombie extends RenderLiving
{
 protected ModelDressedZombie model;
 
 public RenderDressedZombie (ModelDressedZombie ModelDressedZombie, float f)
 {
  super(ModelDressedZombie, f);
  model = ((ModelDressedZombie)mainModel);
 }
 
 public void renderTutorial(EntityDressedZombie entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderTutorial((EntityDressedZombie)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderTutorial((EntityDressedZombie)par1Entity, par2, par4, par6, par8, par9);
    }
}