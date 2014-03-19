package cliffracerx.mods.cliffiestaints.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class NormalBlock extends Block
{
    private String tex;
    
    public NormalBlock(int id, Material material, String texture)
    {
        super(id, material);
        this.tex = texture;
        setTextureName("CliffiesTaints:" + texture);
    }
}
