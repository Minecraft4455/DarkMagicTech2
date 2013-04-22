package mods.me.minecraft4455.dmt2.core;

import mods.me.minecraft4455.dmt2.containers.ContainerHullConstructer;
import mods.me.minecraft4455.dmt2.containers.ContainerWriter;
import mods.me.minecraft4455.dmt2.core.gui.GuiHullConstructer;
import mods.me.minecraft4455.dmt2.core.gui.GuiWriter;
import mods.me.minecraft4455.dmt2.lib.GUIIDS;
import mods.me.minecraft4455.dmt2.tileentitys.TileHullConstructer;
import mods.me.minecraft4455.dmt2.tileentitys.TileWriter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

  @Override
     public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
    
   if (!world.blockExists(x, y, z))
    return null;

   TileEntity tile = world.getBlockTileEntity(x, y, z);

   switch (ID) {

   case GUIIDS.WriterID:
    if (!(tile instanceof TileWriter))
     return null;
    return new GuiWriter(player.inventory, (TileWriter) tile);
    
   case GUIIDS.HullConstructerID:
       if (!(tile instanceof TileHullConstructer))
        return null;
       return new GuiHullConstructer(player.inventory, (TileHullConstructer) tile);

   default:
    return null;
   }
     }
 
 
   @Override
      public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
     
    if (!world.blockExists(x, y, z))
    return null;

   TileEntity tile = world.getBlockTileEntity(x, y, z);

   switch (ID) {

   case GUIIDS.WriterID:
    if (!(tile instanceof TileWriter))
     return null;
    return new ContainerWriter(player.inventory, (TileWriter) tile);

   case GUIIDS.HullConstructerID:
       if (!(tile instanceof TileHullConstructer))
        return null;
       return new ContainerHullConstructer(player.inventory, (TileHullConstructer) tile);


   default:
    return null;
   }
     
   }
 
}
