package com.camp.item;
 
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.example.examplemod.ExampleMod;
 
public class CustomItem extends Item {
	
	  ItemManager Items = new ItemManager();
    
	  
	  public final String name = "CustomItem";
  
    public CustomItem(){
        super();
       Item setUnlocalizedName = this.setUnlocalizedName(ExampleMod.MODID + "_" + this.name);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.setMaxDamage(100);     
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
            World worldIn, BlockPos pos, EnumFacing side, float hitX,
            float hitY, float hitZ) {
    	
    	if (playerIn.inventory.hasItem(Items.customAmmo))
        {
         	 worldIn.createExplosion(playerIn, pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 3.0f, true);
			
         	 playerIn.inventory.consumeInventoryItem(Items.customAmmo);
    	}    
         	return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
         	
         	
    }
    	
     
 
     
}