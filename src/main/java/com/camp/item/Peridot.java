package com.camp.item;

import com.example.examplemod.ExampleMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Peridot extends Item {
	
	public final String name = "Peridot";

	public Peridot(){
		super();
		Item setUnlocalizedName = this.setUnlocalizedName(ExampleMod.MODID + "_" + this.name);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(64);
	}

}
