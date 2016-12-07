package com.camp.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import com.camp.block.BlockManager;

public class CustomBiome extends BiomeGenBase {
 
    public CustomBiome(int p_i1971_1_, boolean register) {
        super(p_i1971_1_, register);
        // TODO Auto-generated constructor stub
        this.fillerBlock = Blocks.dirt.getDefaultState();
        this.topBlock = Blocks.mycelium.getDefaultState();
        this.waterColorMultiplier = 0x00FFFF;
        enableSnow = true;
        enableRain = false;
        
        this.theBiomeDecorator.treesPerChunk = 5;
        this.theBiomeDecorator.generateLakes = true;
        this.theBiomeDecorator.clayPerChunk = 5;
        
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.addAll(spawnableCreatureList);
        //this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 20, 4, 2));
    }
     
}