package com.camp.block;

import net.minecraftforge.fml.common.registry.GameRegistry;



public class BlockManager {
	
	
	public static CustomBlock customBlock;
	public static CoolGrass coolGrass;

	 public static void mainRegistry() {
	        initializeBlock();
	        registerBlock();
	    }
	 
	    public static void initializeBlock() {
	    	
	    	customBlock = new CustomBlock();
	    	coolGrass = new CoolGrass();
	 
	    }
	 
	    public static void registerBlock() {
	    	
	    	
	    	  GameRegistry.registerBlock(customBlock, customBlock.name);
	    	  GameRegistry.registerBlock(coolGrass, coolGrass.name);
	    
	    
	    }
}

