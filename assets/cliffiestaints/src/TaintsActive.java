package cliffracerx.mods.cliffiestaints.src;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.ToolCore;

public class TaintsActive extends ActiveToolMod
{
    Random random = new Random();
    
    @Override
    public void updateTool (ToolCore tool, ItemStack stack, World world, Entity entity)
    {
        if (!world.isRemote && entity instanceof EntityLivingBase && !((EntityLivingBase) entity).isSwingInProgress && stack.getTagCompound() != null)
        {
            NBTTagCompound tags = stack.getTagCompound().getCompoundTag("InfiTool");
            //String[] colorNames = {"r", "o", "y", "l", "g", "c", "b", "p"};
            //for(int i=0; i<8; i++)
            {
                if (tags.getBoolean("ATaint"))
                {
                    int chance = 25;
                    int check = world.canBlockSeeTheSky((int) entity.posX, (int) entity.posY, (int) entity.posZ) ? 350 : 1150;
                    if (random.nextInt(check) < chance)
                    {
                        AbilityHelper.healTool(stack, 1, (EntityLivingBase) entity, true);
                    }
                }
            }
        }
    }
}
