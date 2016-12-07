package com.example.examplemod;
 


import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import com.camp.biome.CustomBiome;
import com.camp.block.BlockManager;
import com.camp.block.Overwrite;
import com.camp.item.ItemManager;
import com.camp.world.CustomWorldGenerator;
 
 
@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    
    ItemManager items = new ItemManager();
    public static CustomWorldGenerator customOreGenerator;
    public static BiomeGenBase customBiome;
    
    private static int lastBiomeID = 0;
    public static int getEmptyBiomeID(){
        int i;
        BiomeGenBase[] array = BiomeGenBase.getBiomeGenArray();
        
        //loop through biome array to find an empty id.
        for(i = lastBiomeID; i < array.length; i++){
            if( array[i] == null){
                // Found an empty spot
                // Set lastBiomeID then return index.
                lastBiomeID = i;
                return i;
            }
        }
        // didn't find an empty spot
        return -1;
    }
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
 
    	ItemManager.mainRegistry();
        BlockManager.mainRegistry();
 
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	

    	GameRegistry.addShapedRecipe(new ItemStack(items.customItem),"ede"," i ", " i ", 'e', items.peridot, 'd', Items.diamond, 'i', Items.iron_ingot);
    	GameRegistry.addShapelessRecipe(new ItemStack(items.customAmmo, 8), items.peridot, Items.iron_ingot);
        GameRegistry.addSmelting(new ItemStack(Items.magma_cream),new ItemStack(items.peridot, 4), 0.2f );
        
    	
    	if(event.getSide() == Side.CLIENT)
        {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            
            
            renderItem.getItemModelMesher().register(ItemManager.customAmmo,0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customAmmo.name, "inventory" ));
            renderItem.getItemModelMesher().register(ItemManager.customItem, 0, new ModelResourceLocation(this.MODID + ":" + ItemManager.customItem.name, "inventory"));
            renderItem.getItemModelMesher().register(ItemManager.peridot,0, new ModelResourceLocation(this.MODID + ":" + ItemManager.peridot.name, "inventory" ));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.customBlock), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.customBlock.name, "inventory"));
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(BlockManager.coolGrass), 0, new ModelResourceLocation(this.MODID + ":" + BlockManager.coolGrass.name, "inventory"));
        }
    	
    	customOreGenerator = new CustomWorldGenerator();
        GameRegistry.registerWorldGenerator(customOreGenerator, 2);
        
        
        int biomeId = getEmptyBiomeID();
        if(biomeId != -1){
        	customBiome = new CustomBiome(biomeId, true).setBiomeName("Highland Green").setHeight(new Height(1.5f, 0.05f));
        	BiomeEntry customEntry = new BiomeEntry(customBiome,80);
        	BiomeManager.addBiome(BiomeType.WARM, customEntry);
        	BiomeManager.addSpawnBiome(customBiome);
        	
        }
        
       
        
        
    }
}