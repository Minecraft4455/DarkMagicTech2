package mods.me.minecraft4455.dmt2.core.gui;

import mods.me.minecraft4455.dmt2.containers.ContainerHullConstructer;
import mods.me.minecraft4455.dmt2.tileentitys.TileHullConstructer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

    public class GuiHullConstructer extends GuiContainer {

        public GuiHullConstructer(InventoryPlayer player_inventory, TileHullConstructer tile){
            super(new ContainerHullConstructer(player_inventory, tile));
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int i, int j){
         fontRenderer.drawString("Hull Constructer", 60, 6, 0x354040);
 
         }

        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                 int par3) {
 
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture("/mods/minecraft4455/textures/gui/HullConstructer.png");
            int x = (width - xSize) / 2;
            int y = (height - ySize) / 2;
            this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
      }
        public boolean doesGuiPauseGame()
        {
            return false;
        }
      
}