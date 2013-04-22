package mods.me.minecraft4455.dmt2.tileentitys;

import mods.me.minecraft4455.dmt2.containers.ContainerHullConstructer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileHullConstructer extends TileEntity implements IInventory {

 private ItemStack[] inventory;

  
    public TileHullConstructer(){
            this.inventory = new ItemStack[ContainerHullConstructer.InputSlotNumber];
            this.canUpdate();
           
    }
   
    @Override
    public int getSizeInventory(){
            return this.inventory.length;
    }
   
    
    @Override
    public ItemStack getStackInSlot(int slotIndex){
            return this.inventory[slotIndex];
    }
   
    
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack){
            this.inventory[slot] = stack;
           
            if(stack != null && stack.stackSize > getInventoryStackLimit()){
                    stack.stackSize = getInventoryStackLimit();
            }
    }
   
   
    @Override
    public ItemStack decrStackSize(int slotIndex, int amount){
   
            ItemStack stack = getStackInSlot(slotIndex);
           
           
            if(stack != null){
           
                    if(stack.stackSize <= amount){
                            setInventorySlotContents(slotIndex, null);
                    }
                    else{
                            stack = stack.splitStack(amount);
                            if(stack.stackSize == 0){
                                    setInventorySlotContents(slotIndex, null);
                            }
                    }
            }
   
   
            return stack;
    }
   
   
    @Override
    public ItemStack getStackInSlotOnClosing(int slotIndex){
   
            ItemStack stack = getStackInSlot(slotIndex);
           
           
            if(stack != null){
                    setInventorySlotContents(slotIndex, null);
            }
           
           
            return stack;
    }
   
   
    @Override
    public int getInventoryStackLimit(){
            return 64;
    }
   
   
    @Override
    public boolean isUseableByPlayer(EntityPlayer player){
            return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }
  
   
    @Override
    public void openChest() {}
   
    
    @Override
    public void closeChest() {}
   
   
    @Override
    public String getInvName(){
    return "TileHullConstructer";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        return false;
    }
}
