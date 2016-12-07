package com.camp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.example.examplemod.ExampleMod;

public class CustomAmmo extends Item {

	public final String name = "CustomAmmo";

	public CustomAmmo(){
		super();
		Item setUnlocalizedName = this.setUnlocalizedName(ExampleMod.MODID + "_" + this.name);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(64);
	}


}

