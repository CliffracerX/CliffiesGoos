package cliffracerx.mods.cliffiestaints.src;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerateGoo implements IWorldGenerator
{
        @Override
        public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
        {
            if(random.nextInt(5)==0)
            {
                int[] gooIDs = {CliffiesTaints.rTaint1.blockID, CliffiesTaints.oTaint1.blockID, CliffiesTaints.yTaint1.blockID, CliffiesTaints.lTaint1.blockID, CliffiesTaints.gTaint1.blockID, CliffiesTaints.cTaint1.blockID, CliffiesTaints.bTaint1.blockID, CliffiesTaints.pTaint1.blockID};
                if(random.nextInt(10)==0)
                    world.setBlock(chunkX*16 + random.nextInt(16), world.getFirstUncoveredBlock(chunkX*16, chunkZ*16), chunkZ*16 + random.nextInt(16), gooIDs[random.nextInt(8)]);
            }
            else
            {
                int[] gooIDs = {CliffiesTaints.rTaint.blockID, CliffiesTaints.oTaint.blockID, CliffiesTaints.yTaint.blockID, CliffiesTaints.lTaint.blockID, CliffiesTaints.gTaint.blockID, CliffiesTaints.cTaint.blockID, CliffiesTaints.bTaint.blockID, CliffiesTaints.pTaint.blockID};
                if(random.nextInt(10)==0)
                    world.setBlock(chunkX*16 + random.nextInt(16), world.getFirstUncoveredBlock(chunkX*16, chunkZ*16), chunkZ*16 + random.nextInt(16), gooIDs[random.nextInt(8)]);
            }
        }
}