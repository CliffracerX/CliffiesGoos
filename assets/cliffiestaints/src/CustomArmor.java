package cliffracerx.mods.cliffiestaints.src;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomArmor extends ItemArmor
{
    private final EnumArmorMaterial material;
    private String texture;

    public CustomArmor(int id, int armorIndex, String tex, EnumArmorMaterial mat, int ind)
    {
        super(id, mat, ind, armorIndex);
        this.material = mat;
        this.setUnlocalizedName(tex + "_1");
        this.setTextureName("CliffiesTaints:"+tex);
        this.texture=tex;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return CliffiesTaints.tab;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
        return "CliffiesTaints:textures/models/armor/"+this.texture+"_1.png";
    }
}