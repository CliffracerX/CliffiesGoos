package cliffracerx.mods.cliffiestaints.src;

import tconstruct.items.tools.Broadsword;
import tconstruct.items.tools.Hatchet;
import tconstruct.items.tools.Longsword;
import tconstruct.items.tools.Pickaxe;
import tconstruct.items.tools.Shovel;
import tconstruct.modifiers.tools.ModBoolean;
import tconstruct.util.config.PHConstruct;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ModFField extends ModBoolean
{

    public ModFField(ItemStack[] items, int effect, String tag, String c, String tip)
    {
        super(items, effect, tag, c, tip);
    }

    @Override
    protected boolean canModify (ItemStack tool, ItemStack[] input)
    {
        NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
        return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key) && !tags.getBoolean("FField") && (tool.getItem() instanceof Pickaxe || tool.getItem() instanceof Longsword || tool.getItem() instanceof Hatchet || tool.getItem() instanceof Shovel || tool.getItem() instanceof Broadsword); //Will fail if the modifier is false or the tag doesn't exist
    }

    @Override
    public void modify (ItemStack[] input, ItemStack tool)
    {
        NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
        int attack = tags.getInteger("Attack");
        attack *= 1.5f;
        tags.setInteger("Attack", attack);
        int base = tags.getInteger("BaseDurability");
        int bonus = tags.getInteger("BonusDurability");
        float modDur = tags.getFloat("ModDurability");
        int mLevel = tags.getInteger("HarvestLevel");
        int miningSpeed = tags.getInteger("MiningSpeed");

        bonus  = 3;
        modDur = 1;
        miningSpeed *= 2;

        int total = (int) ((base * bonus) * (modDur));
        tags.setInteger("TotalDurability", total);
        tags.setInteger("BonusDurability", 0);
        tags.setFloat("ModDurability", modDur);
        tags.setInteger("HarvestLevel", mLevel+1);
        tags.setInteger("MiningSpeed", miningSpeed);
        tags.setBoolean("FField", true);
        int modifiers = tags.getInteger("Modifiers");
        modifiers -= 1;
        tags.setInteger("Modifiers", modifiers);
    }
}
