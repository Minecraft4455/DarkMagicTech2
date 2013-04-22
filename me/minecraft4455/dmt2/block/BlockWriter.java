package mods.me.minecraft4455.dmt2.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.me.minecraft4455.dmt2.DarkMagicTech2;
import mods.me.minecraft4455.dmt2.lib.GUIIDS;
import mods.me.minecraft4455.dmt2.tileentitys.TileWriter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

    public class BlockWriter extends BlockContainer {
        @SideOnly(Side.CLIENT)
        private Icon field_94458_cO;
        @SideOnly(Side.CLIENT)
        private Icon field_94459_cP;
        public BlockWriter(int id) {
            super(id, Material.iron);
            this.setHardness(5.2F);
            this.setResistance(10.0F);
            this.setCreativeTab(CreativeTabs.tabDecorations);
            this.setUnlocalizedName("Writer");
        }
        public void onBlockAdded(World par1World, int par2, int par3, int par4)
        {
            super.onBlockAdded(par1World, par2, par3, par4);
            this.setDefaultDirection(par1World, par2, par3, par4);
        }
        @SideOnly(Side.CLIENT)
        public Icon getIcon(int par1, int par2)
        {
            return par1 == 1 ? this.field_94458_cO : (par1 == 0 ? this.field_94458_cO : (par1 != par2 ? this.blockIcon : this.field_94459_cP));
        }

        @Override
        public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
            TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
        
            if(tile_entity == null || player.isSneaking()){
                return false;
            }

            player.openGui(DarkMagicTech2.instance, GUIIDS.WriterID, world, x, y, z);
            return true;
            }


        @Override
        public void breakBlock(World world, int x, int y, int z, int i, int j) {
            super.breakBlock(world, x, y, z, i, j);
            }

 
        @Override
        public TileEntity createNewTileEntity(World world) {
            return new TileWriter();
        }
        @SideOnly(Side.CLIENT)
        private void setDefaultDirection(World par1World, int par2, int par3, int par4)
        {
            if (!par1World.isRemote)
            {
                int l = par1World.getBlockId(par2, par3, par4 - 1);
                int i1 = par1World.getBlockId(par2, par3, par4 + 1);
                int j1 = par1World.getBlockId(par2 - 1, par3, par4);
                int k1 = par1World.getBlockId(par2 + 1, par3, par4);
                byte b0 = 3;

                if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
                {
                    b0 = 3;
                }

                if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
                {
                    b0 = 2;
                }

                if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
                {
                    b0 = 5;
                }

                if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
                {
                    b0 = 4;
                }

                par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
            }
        }
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister)
        {
            this.blockIcon = par1IconRegister.registerIcon("minecraft4455:Writer_side");
            this.field_94459_cP = par1IconRegister.registerIcon("minecraft4455:Writer_front");
            this.field_94458_cO = par1IconRegister.registerIcon("minecraft4455:Writer_top");
        }
        public static IPosition getIPositionFromBlockSource(IBlockSource par0IBlockSource)
        {
            EnumFacing enumfacing = getFacing(par0IBlockSource.getBlockMetadata());
            double d0 = par0IBlockSource.getX() + 0.7D * (double)enumfacing.getFrontOffsetX();
            double d1 = par0IBlockSource.getY() + 0.7D * (double)enumfacing.getFrontOffsetY();
            double d2 = par0IBlockSource.getZ() + 0.7D * (double)enumfacing.getFrontOffsetZ();
            return new PositionImpl(d0, d1, d2);
        }

        public static EnumFacing getFacing(int par0)
        {
            return EnumFacing.getFront(par0 & 7);
        }
       


        
 }
