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
import net.minecraftforge.common.Configuration;
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
    public boolean worldGenEnabled = false;
    public boolean expensiveAntiTaint = false;
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
    public final static Block rTaint1 = new Tier1Taint(2016,
            Material.ground, "rTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("rTaint1").setCreativeTab(tab);
    public final static Block oTaint1 = new Tier1Taint(2017,
            Material.ground, "oTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("oTaint1").setCreativeTab(tab);
    public final static Block yTaint1 = new Tier1Taint(2018,
            Material.ground, "yTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("yTaint1").setCreativeTab(tab);
    public final static Block lTaint1 = new Tier1Taint(2019,
            Material.ground, "lTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("lTaint1").setCreativeTab(tab);
    public final static Block gTaint1 = new Tier1Taint(2020,
            Material.ground, "gTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("gTaint1").setCreativeTab(tab);
    public final static Block cTaint1 = new Tier1Taint(2021,
            Material.ground, "cTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("cTaint1").setCreativeTab(tab);
    public final static Block bTaint1 = new Tier1Taint(2022,
            Material.ground, "bTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("bTaint1").setCreativeTab(tab);
    public final static Block pTaint1 = new Tier1Taint(2023,
            Material.ground, "pTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setUnlocalizedName("pTaint1").setCreativeTab(tab);
    
    @Instance("CliffiesTaints")
    public static CliffiesTaints instance;
    
    @SidedProxy(clientSide = "cliffracerx.mods.cliffiestaints.src.ClientProxy",
            serverSide = "cliffracerx.mods.cliffiestaints.src.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //Openblocks donation station support.  Support the modders, without them needing to resort to adfly!  =D
        FMLInterModComms.sendMessage("CliffiesTaints", "donateUrl", "http://cliffracerx.github.io/CliffiesTaints/donate.html");
        //Config.
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        worldGenEnabled = config.get(Configuration.CATEGORY_GENERAL, "Generate Goo", true).getBoolean(true);
        expensiveAntiTaint = config.get(Configuration.CATEGORY_GENERAL, "Expensive anti-taint", false).getBoolean(false);
        // saving the configuration to its file
        config.save();
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
        LanguageRegistry.addName(rTaint1, "Red Tainted goo (lv 1)");
        GameRegistry.registerBlock(rTaint1, "rTaint1");
        LanguageRegistry.addName(oTaint1, "Orange Tainted goo (lv 1)");
        GameRegistry.registerBlock(oTaint1, "oTaint1");
        LanguageRegistry.addName(yTaint1, "Yellow Tainted goo (lv 1)");
        GameRegistry.registerBlock(yTaint1, "yTaint1");
        LanguageRegistry.addName(lTaint1, "Lime Tainted goo (lv 1)");
        GameRegistry.registerBlock(lTaint1, "lTaint1");
        LanguageRegistry.addName(gTaint1, "Green Tainted goo (lv 1)");
        GameRegistry.registerBlock(gTaint1, "gTaint1");
        LanguageRegistry.addName(cTaint1, "Cyan Tainted goo (lv 1)");
        GameRegistry.registerBlock(cTaint1, "cTaint1");
        LanguageRegistry.addName(bTaint1, "Blue Tainted goo (lv 1)");
        GameRegistry.registerBlock(bTaint1, "bTaint1");
        LanguageRegistry.addName(pTaint1, "Purple Tainted goo (lv 1)");
        GameRegistry.registerBlock(pTaint1, "pTaint1");
        //Event handler
        MinecraftForge.EVENT_BUS.register(new TaintsEventHandler());
        //Turn on the world gen if it's enabled.
        if(worldGenEnabled)
            GameRegistry.registerWorldGenerator(new GenerateGoo());
        //Crafting
        if(expensiveAntiTaint)
        {
            GameRegistry.addRecipe(new ItemStack(rATaint, 16), "###",
                    "#$#", "###", '$', Item.diamond, '#', rTaint);
            GameRegistry.addRecipe(new ItemStack(oATaint, 16), "###",
                    "#$#", "###", '$', Item.diamond, '#', oTaint);
            GameRegistry.addRecipe(new ItemStack(yATaint, 16), "###",
                    "#$#", "###", '$', Item.diamond, '#', yTaint);
            GameRegistry.addRecipe(new ItemStack(lATaint, 16), "###",
                    "#$#", "###", '$', Item.diamond, '#', lTaint);
            GameRegistry.addRecipe(new ItemStack(gATaint, 16), "###",
                    "#$#", "###", '$', Item.diamond, '#', gTaint);
            GameRegistry.addRecipe(new ItemStack(cATaint, 16), "###",
                    "#$#", "###", '$', Item.diamond, '#', cTaint);
            GameRegistry.addRecipe(new ItemStack(bATaint, 16), "###",
                    "#$#", "###", '$', Item.diamond, '#', bTaint);
            GameRegistry.addRecipe(new ItemStack(pATaint, 16), "###",
                    "#$#", "###", '$', Item.diamond, '#', pTaint);
        }
        else
        {
            GameRegistry.addRecipe(new ItemStack(rATaint, 16), "###",
                    "#$#", "###", '$', Block.stone, '#', rTaint);
            GameRegistry.addRecipe(new ItemStack(oATaint, 16), "###",
                    "#$#", "###", '$', Block.stone, '#', oTaint);
            GameRegistry.addRecipe(new ItemStack(yATaint, 16), "###",
                    "#$#", "###", '$', Block.stone, '#', yTaint);
            GameRegistry.addRecipe(new ItemStack(lATaint, 16), "###",
                    "#$#", "###", '$', Block.stone, '#', lTaint);
            GameRegistry.addRecipe(new ItemStack(gATaint, 16), "###",
                    "#$#", "###", '$', Block.stone, '#', gTaint);
            GameRegistry.addRecipe(new ItemStack(cATaint, 16), "###",
                    "#$#", "###", '$', Block.stone, '#', cTaint);
            GameRegistry.addRecipe(new ItemStack(bATaint, 16), "###",
                    "#$#", "###", '$', Block.stone, '#', bTaint);
            GameRegistry.addRecipe(new ItemStack(pATaint, 16), "###",
                    "#$#", "###", '$', Block.stone, '#', pTaint);
        }
        GameRegistry.addRecipe(new ItemStack(rTaint1, 1), "###",
                "#$#", "###", '$', rTaint, '#', rTaint);
        GameRegistry.addRecipe(new ItemStack(oTaint1, 1), "###",
                "#$#", "###", '$', oTaint, '#', oTaint);
        GameRegistry.addRecipe(new ItemStack(yTaint1, 1), "###",
                "#$#", "###", '$', yTaint, '#', yTaint);
        GameRegistry.addRecipe(new ItemStack(lTaint1, 1), "###",
                "#$#", "###", '$', lTaint, '#', lTaint);
        GameRegistry.addRecipe(new ItemStack(gTaint1, 1), "###",
                "#$#", "###", '$', gTaint, '#', gTaint);
        GameRegistry.addRecipe(new ItemStack(cTaint1, 1), "###",
                "#$#", "###", '$', cTaint, '#', cTaint);
        GameRegistry.addRecipe(new ItemStack(bTaint1, 1), "###",
                "#$#", "###", '$', bTaint, '#', bTaint);
        GameRegistry.addRecipe(new ItemStack(pTaint1, 1), "###",
                "#$#", "###", '$', pTaint, '#', pTaint);
    }
}
