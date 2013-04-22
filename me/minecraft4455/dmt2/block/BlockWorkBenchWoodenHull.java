package mods.me.minecraft4455.dmt2.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockWorkBenchWoodenHull extends Block {
    public BlockWorkBenchWoodenHull(int id) {
        super(id, Material.wood);
        this.setResistance(5F);
        this.setHardness(5F);
        this.setUnlocalizedName("WorkBenchWoodenHull");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundWoodFootstep);
    }
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("minecraft4455:WorkBenchWoodenHull");
    }
}
