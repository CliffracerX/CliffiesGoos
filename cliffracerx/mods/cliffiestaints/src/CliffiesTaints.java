package cliffracerx.mods.cliffiestaints.src;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockStationary;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.common.event.FMLInterModComms;

@Mod(modid = "CliffiesTaints", name = "Cliffie's Tainted Crap",
        version = "Alpha 0.01a")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CliffiesTaints
{
    public final static CreativeTabs tab = new TaintedTab("taintedTab");
    public final static StepSound soundSplutFootstep = new StepSound("cliffiestaints:splut", 1, 1);
    public final static StepSound soundThunkFootstep = new StepSound("cliffiestaints:thunk", 1, 1);
    public final static Block rTaint = new NormalTaint(2000,
            Material.ground, "rTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("rTaint").setCreativeTab(tab);
    public final static Block rATaint = new NormalBlock(2001,
            Material.ground, "rATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setUnlocalizedName("rATaint").setCreativeTab(tab);
    public final static Block oTaint = new NormalTaint(2002,
            Material.ground, "oTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("oTaint").setCreativeTab(tab);
    public final static Block oATaint = new NormalBlock(2003,
            Material.ground, "oATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setUnlocalizedName("oATaint").setCreativeTab(tab);
    public final static Block yTaint = new NormalTaint(2004,
            Material.ground, "yTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("yTaint").setCreativeTab(tab);
    public final static Block yATaint = new NormalBlock(2005,
            Material.ground, "yATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setUnlocalizedName("yATaint").setCreativeTab(tab);
    public final static Block lTaint = new NormalTaint(2006,
            Material.ground, "lTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("lTaint").setCreativeTab(tab);
    public final static Block lATaint = new NormalBlock(2007,
            Material.ground, "lATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setUnlocalizedName("lATaint").setCreativeTab(tab);
    public final static Block gTaint = new NormalTaint(2008,
            Material.ground, "gTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("gTaint").setCreativeTab(tab);
    public final static Block gATaint = new NormalBlock(2009,
            Material.ground, "gATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setUnlocalizedName("gATaint").setCreativeTab(tab);
    public final static Block cTaint = new NormalTaint(2010,
            Material.ground, "cTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("cTaint").setCreativeTab(tab);
    public final static Block cATaint = new NormalBlock(2011,
            Material.ground, "cATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setUnlocalizedName("cATaint").setCreativeTab(tab);
    public final static Block bTaint = new NormalTaint(2012,
            Material.ground, "bTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("bTaint").setCreativeTab(tab);
    public final static Block bATaint = new NormalBlock(2013,
            Material.ground, "bATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setUnlocalizedName("bATaint").setCreativeTab(tab);
    public final static Block pTaint = new NormalTaint(2014,
            Material.ground, "pTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("pTaint").setCreativeTab(tab);
    public final static Block pATaint = new NormalBlock(2015,
            Material.ground, "pATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setUnlocalizedName("pATaint").setCreativeTab(tab);
    
    @Instance("CliffiesTaints")
    public static CliffiesTaints instance;
    
    @SidedProxy(clientSide = "cliffracerx.mods.cliffiestaints.src.ClientProxy",
            serverSide = "cliffracerx.mods.cliffiestaints.src.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FMLInterModComms.sendMessage("CliffiesTaints", "donateUrl", "http://cliffracerx.github.io/CliffiesTaints/donate.html");
    }
    
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void load(FMLInitializationEvent event)
    {
        ClientProxy.registerRenderers();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //Block naming and registering
        LanguageRegistry.addName(rTaint, "Red Tainted goo (lv 0)");
        GameRegistry.registerBlock(rTaint, "rTaint");
        LanguageRegistry.addName(rATaint, "Red Anti-Taint wall");
        GameRegistry.registerBlock(rATaint, "rATaint");
        LanguageRegistry.addName(oTaint, "Orange Tainted goo (lv 0)");
        GameRegistry.registerBlock(oTaint, "oTaint");
        LanguageRegistry.addName(oATaint, "Orange Anti-Taint wall");
        GameRegistry.registerBlock(oATaint, "oATaint");
        LanguageRegistry.addName(yTaint, "Yellow Tainted goo (lv 0)");
        GameRegistry.registerBlock(yTaint, "yTaint");
        LanguageRegistry.addName(yATaint, "Yellow Anti-Taint wall");
        GameRegistry.registerBlock(yATaint, "yATaint");
        LanguageRegistry.addName(lTaint, "Lime Tainted goo (lv 0)");
        GameRegistry.registerBlock(lTaint, "lTaint");
        LanguageRegistry.addName(lATaint, "Lime Anti-Taint wall");
        GameRegistry.registerBlock(lATaint, "lATaint");
        LanguageRegistry.addName(gTaint, "Green Tainted goo (lv 0)");
        GameRegistry.registerBlock(gTaint, "gTaint");
        LanguageRegistry.addName(gATaint, "Green Anti-Taint wall");
        GameRegistry.registerBlock(gATaint, "gATaint");
        LanguageRegistry.addName(cTaint, "Cyan Tainted goo (lv 0)");
        GameRegistry.registerBlock(cTaint, "cTaint");
        LanguageRegistry.addName(cATaint, "Cyan Anti-Taint wall");
        GameRegistry.registerBlock(cATaint, "cATaint");
        LanguageRegistry.addName(bTaint, "Blue Tainted goo (lv 0)");
        GameRegistry.registerBlock(bTaint, "bTaint");
        LanguageRegistry.addName(bATaint, "Blue Anti-Taint wall");
        GameRegistry.registerBlock(bATaint, "bATaint");
        LanguageRegistry.addName(pTaint, "Purple Tainted goo (lv 0)");
        GameRegistry.registerBlock(pTaint, "pTaint");
        LanguageRegistry.addName(pATaint, "Purple Anti-Taint wall");
        GameRegistry.registerBlock(pATaint, "pATaint");
        //Event handler
        MinecraftForge.EVENT_BUS.register(new TaintsEventHandler());
    }
}
