package cliffracerx.mods.cliffiestaints.src;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Tier3Taint extends Tier2Taint
{
    /**
     * Private texture file.
     */
    private String tex;
    
    /**
     * Gaseous and normal at the same type, this is very bad!
     * This WILL kill you.  Spreads through air, and onto non-bedrock and non-forcefield type blocks.
     * This is a Lv. 3 / nearly end of the world taint.
     * @param id
     * @param material
     * @param texture
     */
    public Tier3Taint(int id, Material material, String texture)
    {
        super(id, material, texture);
        this.tex = texture;
        this.setTickRandomly(true);
        setTextureName("CliffiesTaints:" + texture);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }
    
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        int i1 = par1IBlockAccess.getBlockId(par2, par3, par4);
        return i1 == this.blockID ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
    
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return AxisAlignedBB.getAABBPool().getAABB((double)par2 + 0, (double)par3 + 0, (double)par4 + 0, (double)par2 + 0, (double)par3 + 0, (double)par4 + 0);
    }
    
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    /**
     * Block update.
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(1) - 1;
                    int j1 = par3 + par5Random.nextInt(1) - 1;
                    int k1 = par4 + par5Random.nextInt(1) - 1;

                    //Spread onto all blocks that aren't bedrock, or force fields/airlocks.
                    if (par1World.getBlockId(i1, j1, k1) != Block.bedrock.blockID && !((Block.blocksList[par1World.getBlockId(i1, j1, k1)] instanceof AntiTaintTransp) || (Block.blocksList[par1World.getBlockId(i1, j1, k1)] instanceof AirlockType)))
                    {
                        //System.out.println("Cliffie's Taints: Taint taking over on x: "+i1+" y: "+j1+" z: "+k1);
                        par1World.setBlock(i1, j1, k1, this.blockID);
                        if(par5Random.nextInt(5)==0)
                            par1World.setBlock(par2, par3, par4, 0);
                    }
                }
            }
        }
    }
    
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if(par5Entity instanceof EntityLivingBase && par5Entity.worldObj.isRemote==false)
        {
            EntityLivingBase living = (EntityLivingBase)par5Entity;
            par5Entity.motionX*=0.25F;
            par5Entity.motionY*=0.25F;
            par5Entity.motionZ*=0.25F;
            par5Entity.fallDistance=0;
            living.addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 2, true));
            if(par1World.rand.nextInt(100)==0)
            living.addPotionEffect(new PotionEffect(Potion.poison.id, 60, 0, true));
        }
    }
}
