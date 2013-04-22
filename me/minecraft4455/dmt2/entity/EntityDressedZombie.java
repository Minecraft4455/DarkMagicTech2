package mods.me.minecraft4455.dmt2.entity;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityDressedZombie extends EntityMob
{
 public EntityDressedZombie(World par1World) 
 {
  super(par1World);
  this.texture = "/mods/minecraft4455/textures/mobs/DressedZombie.png";
  this.moveSpeed = 0.30F;
  this.getNavigator().setBreakDoors(true);
  this.tasks.addTask(0, new EntityAISwimming(this));
  this.tasks.addTask(1, new EntityAIBreakDoor(this));
  this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
  this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.moveSpeed, true));
  this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
  this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
  this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
  this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
  this.tasks.addTask(7, new EntityAILookIdle(this));
  this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
  this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
  this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));
 }
 protected boolean isAIEnabled()
 {
     return true;
 }

public int getAttackStrength(Entity par1Entity)
    {
     return 4;
    }
public int getTotalArmorValue()
{
    return 5;
}
public void onLivingUpdate()
{
    if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
    {
        float var1 = this.getBrightness(1.0F);

        if (var1 > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F)
        {
            this.setFire(8);
        }
    }

    super.onLivingUpdate();
}
protected String getLivingSound()
{
    return "mob.zombie.say";
}

protected String getHurtSound()
{
    return "mob.zombie.hurt";
}

protected String getDeathSound()
{
    return "mob.zombie.death";
}

protected void playStepSound(int par1, int par2, int par3, int par4)
{
    this.worldObj.playSoundAtEntity(this, "mob.zombie.step", 0.15F, 1.0F);
}

 
 public int getMaxHealth() 
 {
  return 40;
 }
 
 public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
 public boolean attackEntityAsMob(Entity par1Entity)
 {
     boolean flag = super.attackEntityAsMob(par1Entity);

     if (flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)this.worldObj.difficultySetting * 0.3F)
     {
         par1Entity.setFire(2 * this.worldObj.difficultySetting);
     }

     return flag;
 }
 protected int getDropItemId()
 {
     return Item.ingotGold.itemID;
 }
 
 protected void dropRareDrop(int par1)
 {
     switch (this.rand.nextInt(2))
     {
         case 0:
             this.dropItem(Item.ingotIron.itemID, 1);
             break;
         case 1:
             this.dropItem(Item.stick.itemID, 1);
             break;
     }
 }
 
 protected void dropFewItems(boolean par1, int par2)
 {
  if(this.rand.nextInt(3) == 0)
  {
   this.dropItem(Item.appleRed.itemID, 1);
  }
 }
}