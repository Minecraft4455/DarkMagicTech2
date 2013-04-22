package mods.me.minecraft4455.dmt2.handler;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

public class RecipeSorterWriter implements Comparator<Object>
{
 final CraftingManagerWriter CraftingManagerCrafter;

 RecipeSorterWriter(CraftingManagerWriter par1CraftingManager)
 {
  CraftingManagerCrafter = par1CraftingManager;
 }

 public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
 {
 if ((par1IRecipe instanceof ShapelessRecipes) && (par2IRecipe instanceof ShapedRecipes))
 {
 return 1;
 }

 if ((par2IRecipe instanceof ShapelessRecipes) && (par1IRecipe instanceof ShapedRecipes))
 {
 return -1;
 }

 if (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize())
 {
 return -1;
 }

 return par2IRecipe.getRecipeSize() <= par1IRecipe.getRecipeSize() ? 0 : 1;
 }

 public int compare(Object par1Obj, Object par2Obj)
 {
 return compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
 }

}
