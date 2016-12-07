package com.camp.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.camp.block.BlockManager;

public class CustomWorldGenerator implements IWorldGenerator{
	 
    /*
     *  Generate will be called each time a 16x16 chunk is generated
     *  Be careful how much code you add here - it gets slow very quickly!
     * 
     */
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        // TODO Auto-generated method stub
    	 switch(world.provider.getDimensionId()){
         case -1:
         // Dim -1 Nether
             break;
         case 0:
             // Dim 0 Surface
             generateSurface(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
             break;
         case 1:
             // Dim 1 End
             break;
          
         }
          
     }
  
     public void generateSurface(Random random, int chunkX, int chunkZ, World world,
             IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
         
          
         // For loop runs 5 times - this will be how many chances to generate a vein of our ore we'll have
             for (int i = 0; i < 5; i++){
                 // Randomize coordinates for ore starting position
                  
                 int startX = chunkX * 16 + random.nextInt(16);
                 int startY = random.nextInt(40) + 16;
                 int startZ = chunkZ * 16 + random.nextInt(16);
                  
                 // Store the coordinates in a BlockPos
                 BlockPos start = new BlockPos(startX, startY, startZ);
                  
                 // Create a new WorldGenMinable with custom block. This will create and place an ore vein    .
                 (new WorldGenMinable(BlockManager.customBlock.getDefaultState(), random.nextInt(5) + 10)).generate(world, random, start);
  
             
          
     }
    }
 
}