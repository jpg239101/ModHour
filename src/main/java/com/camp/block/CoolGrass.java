package com.camp.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.example.examplemod.ExampleMod;

public class CoolGrass extends Block {
	
	
	  public static final String name = "CoolGrass";
	     
	    public CoolGrass() {
	        super(Material.grass);
	        this.setUnlocalizedName(ExampleMod.MODID + "_" + name);
	        this.setCreativeTab(CreativeTabs.tabBlock);
	        this.setLightLevel(0.7f);
	        this.setHardness(0.6f);
	        this.setResistance(0.7f);
	        
	       
	        
	        
	       
	        
	        
	        
	    }
	    
	    @Override
	    public int quantityDropped(Random random)
	    {
	        return 1;
	    }
	 
	    public Block getBlockDropped(IBlockState state, Random rand, int fortune)
	    {
	        return BlockManager.coolGrass;
	    }		
	    
	    
	    
	    @Override
	    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
	    {
	    	
	        return true;
	    }
	    
	 
	    
	   
}