package cliffracerx.mods.cliffiestaints.src;

import tconstruct.common.TContent;
import tconstruct.items.tools.Pickaxe;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ToolBuilder;
import tconstruct.modifiers.tools.TActiveOmniMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "CliffiesTaints", name = "Cliffie's Tainted Crap",
        version = "Alpha 0.01a")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class CliffiesTaints
{
    public final static CreativeTabs tab = new TaintedTab("taintedTab");
    public final static StepSound soundSplutFootstep = new StepSound("cliffiestaints:splut", 1, 1);
    public final static StepSound soundThunkFootstep = new StepSound("cliffiestaints:thunk", 1, 1);
    public final static StepSound soundWooshFootstep = new StepSound("cliffiestaints:woosh", 1, 1);
    public final static StepSound soundZapFootstep = new StepSound("cliffiestaints:zap", 1, 1);
    public final static StepSound soundSplurgFootstep = new StepSound("cliffiestaints:splurg", 1, 1);
    public static EnumArmorMaterial gasMask = EnumHelper.addArmorMaterial("cliffiesGasMask", (int)Double.POSITIVE_INFINITY, new int[]{2, 6, 5, 2}, 9);
    public boolean worldGenEnabled = false;
    public boolean expensiveAntiTaint = false;
    public boolean dangerousTaintCrafting = false;
    public static int rMaskI;
    public static int oMaskI;
    public static int yMaskI;
    public static int lMaskI;
    public static int gMaskI;
    public static int cMaskI;
    public static int bMaskI;
    public static int pMaskI;
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
    public final static Block rTaint2 = new Tier2Taint(2024,
            Material.vine, "rTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setUnlocalizedName("rTaint2").setCreativeTab(tab);
    public final static Block oTaint2 = new Tier2Taint(2025,
            Material.vine, "oTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setUnlocalizedName("oTaint2").setCreativeTab(tab);
    public final static Block yTaint2 = new Tier2Taint(2026,
            Material.vine, "yTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setUnlocalizedName("yTaint2").setCreativeTab(tab);
    public final static Block lTaint2 = new Tier2Taint(2027,
            Material.vine, "lTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setUnlocalizedName("lTaint2").setCreativeTab(tab);
    public final static Block gTaint2 = new Tier2Taint(2028,
            Material.vine, "gTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setUnlocalizedName("gTaint2").setCreativeTab(tab);
    public final static Block cTaint2 = new Tier2Taint(2029,
            Material.vine, "cTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setUnlocalizedName("cTaint2").setCreativeTab(tab);
    public final static Block bTaint2 = new Tier2Taint(2030,
            Material.vine, "bTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setUnlocalizedName("bTaint2").setCreativeTab(tab);
    public final static Block pTaint2 = new Tier2Taint(2031,
            Material.vine, "pTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setUnlocalizedName("pTaint2").setCreativeTab(tab);
    public final static Block rFField = new AntiTaintTransp(2032,
            Material.rock, "rFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("rFField").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block oFField = new AntiTaintTransp(2033,
            Material.rock, "oFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("oFField").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block yFField = new AntiTaintTransp(2034,
            Material.rock, "yFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("yFField").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block lFField = new AntiTaintTransp(2035,
            Material.rock, "lFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("lFField").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block gFField = new AntiTaintTransp(2036,
            Material.rock, "gFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("gFField").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block cFField = new AntiTaintTransp(2037,
            Material.rock, "cFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("cFField").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block bFField = new AntiTaintTransp(2038,
            Material.rock, "bFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("bFField").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block pFField = new AntiTaintTransp(2039,
            Material.rock, "pFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("pFField").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block rFFieldAL = new AirlockType(2040,
            Material.rock, "rFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("rFFieldAL").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block oFFieldAL = new AirlockType(2041,
            Material.rock, "oFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("oFFieldAL").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block yFFieldAL = new AirlockType(2042,
            Material.rock, "yFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("yFFieldAL").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block lFFieldAL = new AirlockType(2043,
            Material.rock, "lFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("lFFieldAL").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block gFFieldAL = new AirlockType(2044,
            Material.rock, "gFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("gFFieldAL").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block cFFieldAL = new AirlockType(2045,
            Material.rock, "cFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("cFFieldAL").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block bFFieldAL = new AirlockType(2046,
            Material.rock, "bFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("bFFieldAL").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block pFFieldAL = new AirlockType(2047,
            Material.rock, "pFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setUnlocalizedName("pFFieldAL").setCreativeTab(tab).setLightValue(1.0F).setResistance(500F);
    public final static Block rTaint3 = new Tier3Taint(2048,
            Material.vine, "rTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setUnlocalizedName("rTaint3").setCreativeTab(tab);
    public final static Block oTaint3 = new Tier3Taint(2049,
            Material.vine, "oTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setUnlocalizedName("oTaint3").setCreativeTab(tab);
    public final static Block yTaint3 = new Tier3Taint(2050,
            Material.vine, "yTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setUnlocalizedName("yTaint3").setCreativeTab(tab);
    public final static Block lTaint3 = new Tier3Taint(2051,
            Material.vine, "lTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setUnlocalizedName("lTaint3").setCreativeTab(tab);
    public final static Block gTaint3 = new Tier3Taint(2052,
            Material.vine, "gTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setUnlocalizedName("gTaint3").setCreativeTab(tab);
    public final static Block cTaint3 = new Tier3Taint(2053,
            Material.vine, "cTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setUnlocalizedName("cTaint3").setCreativeTab(tab);
    public final static Block bTaint3 = new Tier3Taint(2054,
            Material.vine, "bTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setUnlocalizedName("bTaint3").setCreativeTab(tab);
    public final static Block pTaint3 = new Tier3Taint(2055,
            Material.vine, "pTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setUnlocalizedName("pTaint3").setCreativeTab(tab);
    public final static Item rGasMask = new CustomArmor(8192, 0, "rMask", gasMask, rMaskI);
    public final static Item oGasMask = new CustomArmor(8193, 0, "oMask", gasMask, oMaskI);
    public final static Item yGasMask = new CustomArmor(8194, 0, "yMask", gasMask, yMaskI);
    public final static Item lGasMask = new CustomArmor(8195, 0, "lMask", gasMask, lMaskI);
    public final static Item gGasMask = new CustomArmor(8196, 0, "gMask", gasMask, gMaskI);
    public final static Item cGasMask = new CustomArmor(8197, 0, "cMask", gasMask, cMaskI);
    public final static Item bGasMask = new CustomArmor(8198, 0, "bMask", gasMask, bMaskI);
    public final static Item pGasMask = new CustomArmor(8199, 0, "pMask", gasMask, pMaskI);
    
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
        dangerousTaintCrafting = config.get(Configuration.CATEGORY_GENERAL, "Can the dangerous taints be made?", false).getBoolean(false);
        // saving the configuration to its file
        config.save();
    }
    
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void load(FMLInitializationEvent event)
    {
        ClientProxy.registerRenderers();
        rMaskI = ClientProxy.addArmour("rMask");
        oMaskI = ClientProxy.addArmour("oMask");
        yMaskI = ClientProxy.addArmour("yMask");
        lMaskI = ClientProxy.addArmour("lMask");
        gMaskI = ClientProxy.addArmour("gMask");
        cMaskI = ClientProxy.addArmour("cMask");
        bMaskI = ClientProxy.addArmour("bMask");
        pMaskI = ClientProxy.addArmour("pMask");
        if(Loader.isModLoaded("TConstruct"))
        {
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1024, "cliffiestaints", "rFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1025, "cliffiestaints", "oFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1026, "cliffiestaints", "yFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1027, "cliffiestaints", "lFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1028, "cliffiestaints", "gFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1029, "cliffiestaints", "cFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1030, "cliffiestaints", "bFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1031, "cliffiestaints", "pFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1032, "cliffiestaints", "rATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1033, "cliffiestaints", "oATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1034, "cliffiestaints", "yATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1035, "cliffiestaints", "lATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1036, "cliffiestaints", "gATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1037, "cliffiestaints", "cATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1038, "cliffiestaints", "bATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.pickaxe, 1039, "cliffiestaints", "pATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1024, "cliffiestaints", "rFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1025, "cliffiestaints", "oFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1026, "cliffiestaints", "yFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1027, "cliffiestaints", "lFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1028, "cliffiestaints", "gFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1029, "cliffiestaints", "cFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1030, "cliffiestaints", "bFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1031, "cliffiestaints", "pFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1032, "cliffiestaints", "rATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1033, "cliffiestaints", "oATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1034, "cliffiestaints", "yATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1035, "cliffiestaints", "lATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1036, "cliffiestaints", "gATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1037, "cliffiestaints", "cATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1038, "cliffiestaints", "bATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.longsword, 1039, "cliffiestaints", "pATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1024, "cliffiestaints", "rFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1025, "cliffiestaints", "oFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1026, "cliffiestaints", "yFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1027, "cliffiestaints", "lFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1028, "cliffiestaints", "gFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1029, "cliffiestaints", "cFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1030, "cliffiestaints", "bFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1031, "cliffiestaints", "pFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1032, "cliffiestaints", "rATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1033, "cliffiestaints", "oATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1034, "cliffiestaints", "yATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1035, "cliffiestaints", "lATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1036, "cliffiestaints", "gATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1037, "cliffiestaints", "cATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1038, "cliffiestaints", "bATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.shovel, 1039, "cliffiestaints", "pATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1024, "cliffiestaints", "rFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1025, "cliffiestaints", "oFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1026, "cliffiestaints", "yFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1027, "cliffiestaints", "lFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1028, "cliffiestaints", "gFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1029, "cliffiestaints", "cFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1030, "cliffiestaints", "bFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1031, "cliffiestaints", "pFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1032, "cliffiestaints", "rATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1033, "cliffiestaints", "oATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1034, "cliffiestaints", "yATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1035, "cliffiestaints", "lATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1036, "cliffiestaints", "gATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1037, "cliffiestaints", "cATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1038, "cliffiestaints", "bATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.broadsword, 1039, "cliffiestaints", "pATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1024, "cliffiestaints", "rFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1025, "cliffiestaints", "oFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1026, "cliffiestaints", "yFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1027, "cliffiestaints", "lFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1028, "cliffiestaints", "gFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1029, "cliffiestaints", "cFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1030, "cliffiestaints", "bFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1031, "cliffiestaints", "pFField", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1032, "cliffiestaints", "rATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1033, "cliffiestaints", "oATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1034, "cliffiestaints", "yATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1035, "cliffiestaints", "lATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1036, "cliffiestaints", "gATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1037, "cliffiestaints", "cATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1038, "cliffiestaints", "bATaint", true);
        TConstructClientRegistry.addEffectRenderMapping(TContent.hatchet, 1039, "cliffiestaints", "pATaint", true);
        }
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
        LanguageRegistry.addName(rTaint2, "Red Tainted gas (lv 2)");
        GameRegistry.registerBlock(rTaint2, "rTaint2");
        LanguageRegistry.addName(oTaint2, "Orange Tainted gas (lv 2)");
        GameRegistry.registerBlock(oTaint2, "oTaint2");
        LanguageRegistry.addName(yTaint2, "Yellow Tainted gas (lv 2)");
        GameRegistry.registerBlock(yTaint2, "yTaint2");
        LanguageRegistry.addName(lTaint2, "Lime Tainted gas (lv 2)");
        GameRegistry.registerBlock(lTaint2, "lTaint2");
        LanguageRegistry.addName(gTaint2, "Green Tainted gas (lv 2)");
        GameRegistry.registerBlock(gTaint2, "gTaint2");
        LanguageRegistry.addName(cTaint2, "Cyan Tainted gas (lv 2)");
        GameRegistry.registerBlock(cTaint2, "cTaint2");
        LanguageRegistry.addName(bTaint2, "Blue Tainted gas (lv 2)");
        GameRegistry.registerBlock(bTaint2, "bTaint2");
        LanguageRegistry.addName(pTaint2, "Purple Tainted gas (lv 2)");
        GameRegistry.registerBlock(pTaint2, "pTaint2");
        LanguageRegistry.addName(rFField, "Red Force Field");
        GameRegistry.registerBlock(rFField, "rFField");
        LanguageRegistry.addName(oFField, "Orange Force Field");
        GameRegistry.registerBlock(oFField, "oFField");
        LanguageRegistry.addName(yFField, "Yellow Force Field");
        GameRegistry.registerBlock(yFField, "yFField");
        LanguageRegistry.addName(lFField, "Lime Force Field");
        GameRegistry.registerBlock(lFField, "lFField");
        LanguageRegistry.addName(gFField, "Green Force Field");
        GameRegistry.registerBlock(gFField, "gFField");
        LanguageRegistry.addName(cFField, "Cyan Force Field");
        GameRegistry.registerBlock(cFField, "cFField");
        LanguageRegistry.addName(bFField, "Blue Force Field");
        GameRegistry.registerBlock(bFField, "bFField");
        LanguageRegistry.addName(pFField, "Purple Force Field");
        GameRegistry.registerBlock(pFField, "pFField");
        LanguageRegistry.addName(rFFieldAL, "Red Air Lock");
        GameRegistry.registerBlock(rFFieldAL, "rFFieldAL");
        LanguageRegistry.addName(oFFieldAL, "Orange Air Lock");
        GameRegistry.registerBlock(oFFieldAL, "oFFieldAL");
        LanguageRegistry.addName(yFFieldAL, "Yellow Air Lock");
        GameRegistry.registerBlock(yFFieldAL, "yFFieldAL");
        LanguageRegistry.addName(lFFieldAL, "Lime Air Lock");
        GameRegistry.registerBlock(lFFieldAL, "lFFieldAL");
        LanguageRegistry.addName(gFFieldAL, "Green Air Lock");
        GameRegistry.registerBlock(gFFieldAL, "gFFieldAL");
        LanguageRegistry.addName(cFFieldAL, "Cyan Air Lock");
        GameRegistry.registerBlock(cFFieldAL, "cFFieldAL");
        LanguageRegistry.addName(bFFieldAL, "Blue Air Lock");
        GameRegistry.registerBlock(bFFieldAL, "bFFieldAL");
        LanguageRegistry.addName(pFFieldAL, "Purple Air Lock");
        GameRegistry.registerBlock(pFFieldAL, "pFFieldAL");
        LanguageRegistry.addName(rTaint3, "Red Tainted goo (lv 3)");
        GameRegistry.registerBlock(rTaint3, "rTaint3");
        LanguageRegistry.addName(oTaint3, "Orange Tainted goo (lv 3)");
        GameRegistry.registerBlock(oTaint3, "oTaint3");
        LanguageRegistry.addName(yTaint3, "Yellow Tainted goo (lv 3)");
        GameRegistry.registerBlock(yTaint3, "yTaint3");
        LanguageRegistry.addName(lTaint3, "Lime Tainted goo (lv 3)");
        GameRegistry.registerBlock(lTaint3, "lTaint3");
        LanguageRegistry.addName(gTaint3, "Green Tainted goo (lv 3)");
        GameRegistry.registerBlock(gTaint3, "gTaint3");
        LanguageRegistry.addName(cTaint3, "Cyan Tainted goo (lv 3)");
        GameRegistry.registerBlock(cTaint3, "cTaint3");
        LanguageRegistry.addName(bTaint3, "Blue Tainted goo (lv 3)");
        GameRegistry.registerBlock(bTaint3, "bTaint3");
        LanguageRegistry.addName(pTaint3, "Purple Tainted goo (lv 3)");
        GameRegistry.registerBlock(pTaint3, "pTaint3");
        //Event handler
        MinecraftForge.EVENT_BUS.register(new TaintsEventHandler());
        //Turn on the world gen if it's enabled.
        if(worldGenEnabled)
            GameRegistry.registerWorldGenerator(new GenerateGoo());
        //Name items
        LanguageRegistry.addName(rGasMask, "Red gas mask");
        LanguageRegistry.addName(oGasMask, "Orange gas mask");
        LanguageRegistry.addName(yGasMask, "Yellow gas mask");
        LanguageRegistry.addName(lGasMask, "Lime gas mask");
        LanguageRegistry.addName(gGasMask, "Green gas mask");
        LanguageRegistry.addName(cGasMask, "Cyan gas mask");
        LanguageRegistry.addName(bGasMask, "Blue gas mask");
        LanguageRegistry.addName(pGasMask, "Purple gas mask");
        //Add tinkers loot
        if(Loader.isModLoaded("TConstruct"))
        {
        ToolBuilder tb = ToolBuilder.instance;
        tb.registerToolMod(new ModFField(new ItemStack[] { new ItemStack(rFField) }, 1024, "rFField", "\u00a72Durability 10x, attack 2x, mining speed 4x, mining level +2", "\u00a72"));
        tb.registerToolMod(new ModFField(new ItemStack[] { new ItemStack(oFField) }, 1025, "oFField", "\u00a72Durability 10x, attack 2x, mining speed 4x, mining level +2", "\u00a72"));
        tb.registerToolMod(new ModFField(new ItemStack[] { new ItemStack(yFField) }, 1026, "yFField", "\u00a72Durability 10x, attack 2x, mining speed 4x, mining level +2", "\u00a72"));
        tb.registerToolMod(new ModFField(new ItemStack[] { new ItemStack(lFField) }, 1027, "lFField", "\u00a72Durability 10x, attack 2x, mining speed 4x, mining level +2", "\u00a72"));
        tb.registerToolMod(new ModFField(new ItemStack[] { new ItemStack(gFField) }, 1028, "gFField", "\u00a72Durability 10x, attack 2x, mining speed 4x, mining level +2", "\u00a72"));
        tb.registerToolMod(new ModFField(new ItemStack[] { new ItemStack(cFField) }, 1029, "cFField", "\u00a72Durability 10x, attack 2x, mining speed 4x, mining level +2", "\u00a72"));
        tb.registerToolMod(new ModFField(new ItemStack[] { new ItemStack(bFField) }, 1030, "bFField", "\u00a72Durability 10x, attack 2x, mining speed 4x, mining level +2", "\u00a72"));
        tb.registerToolMod(new ModFField(new ItemStack[] { new ItemStack(pFField) }, 1031, "pFField", "\u00a72Durability 10x, attack 2x, mining speed 4x, mining level +2", "\u00a72"));
        tb.registerToolMod(new ModATaint(new ItemStack[] { new ItemStack(rATaint) }, 1032, "rATaint", "\u00a72Durability 3x and autorepairs, attack 3x, mining speed 2x, mining level +1", "\u00a72"));
        tb.registerToolMod(new ModATaint(new ItemStack[] { new ItemStack(oATaint) }, 1033, "oATaint", "\u00a72Durability 3x and autorepairs, attack 3x, mining speed 2x, mining level +1", "\u00a72"));
        tb.registerToolMod(new ModATaint(new ItemStack[] { new ItemStack(yATaint) }, 1034, "yATaint", "\u00a72Durability 3x and autorepairs, attack 3x, mining speed 2x, mining level +1", "\u00a72"));
        tb.registerToolMod(new ModATaint(new ItemStack[] { new ItemStack(lATaint) }, 1035, "lATaint", "\u00a72Durability 3x and autorepairs, attack 3x, mining speed 2x, mining level +1", "\u00a72"));
        tb.registerToolMod(new ModATaint(new ItemStack[] { new ItemStack(gATaint) }, 1036, "gATaint", "\u00a72Durability 3x and autorepairs, attack 3x, mining speed 2x, mining level +1", "\u00a72"));
        tb.registerToolMod(new ModATaint(new ItemStack[] { new ItemStack(cATaint) }, 1037, "cATaint", "\u00a72Durability 3x and autorepairs, attack 3x, mining speed 2x, mining level +1", "\u00a72"));
        tb.registerToolMod(new ModATaint(new ItemStack[] { new ItemStack(bATaint) }, 1038, "bATaint", "\u00a72Durability 3x and autorepairs, attack 3x, mining speed 2x, mining level +1", "\u00a72"));
        tb.registerToolMod(new ModATaint(new ItemStack[] { new ItemStack(pATaint) }, 1039, "pATaint", "\u00a72Durability 3x and autorepairs, attack 3x, mining speed 2x, mining level +1", "\u00a72"));
        TConstructRegistry.registerActiveToolMod(new TaintsActive());
        }
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
        if(dangerousTaintCrafting)
        {
        GameRegistry.addRecipe(new ItemStack(rTaint2, 1), "###",
                "#$#", "###", '$', rTaint, '#', rTaint1);
        GameRegistry.addRecipe(new ItemStack(oTaint2, 1), "###",
                "#$#", "###", '$', oTaint, '#', oTaint1);
        GameRegistry.addRecipe(new ItemStack(yTaint2, 1), "###",
                "#$#", "###", '$', yTaint, '#', yTaint1);
        GameRegistry.addRecipe(new ItemStack(lTaint2, 1), "###",
                "#$#", "###", '$', lTaint, '#', lTaint1);
        GameRegistry.addRecipe(new ItemStack(gTaint2, 1), "###",
                "#$#", "###", '$', gTaint, '#', gTaint1);
        GameRegistry.addRecipe(new ItemStack(cTaint2, 1), "###",
                "#$#", "###", '$', cTaint, '#', cTaint1);
        GameRegistry.addRecipe(new ItemStack(bTaint2, 1), "###",
                "#$#", "###", '$', bTaint, '#', bTaint1);
        GameRegistry.addRecipe(new ItemStack(pTaint2, 1), "###",
                "#$#", "###", '$', pTaint, '#', pTaint1);
        GameRegistry.addRecipe(new ItemStack(rTaint3, 1), "###",
                "#$#", "###", '$', rTaint1, '#', rTaint2);
        GameRegistry.addRecipe(new ItemStack(oTaint3, 1), "###",
                "#$#", "###", '$', oTaint1, '#', oTaint2);
        GameRegistry.addRecipe(new ItemStack(yTaint3, 1), "###",
                "#$#", "###", '$', yTaint1, '#', yTaint2);
        GameRegistry.addRecipe(new ItemStack(lTaint3, 1), "###",
                "#$#", "###", '$', lTaint1, '#', lTaint2);
        GameRegistry.addRecipe(new ItemStack(gTaint3, 1), "###",
                "#$#", "###", '$', gTaint1, '#', gTaint2);
        GameRegistry.addRecipe(new ItemStack(cTaint3, 1), "###",
                "#$#", "###", '$', cTaint1, '#', cTaint2);
        GameRegistry.addRecipe(new ItemStack(bTaint3, 1), "###",
                "#$#", "###", '$', bTaint1, '#', bTaint2);
        GameRegistry.addRecipe(new ItemStack(pTaint3, 1), "###",
                "#$#", "###", '$', pTaint1, '#', pTaint2);
        }
        GameRegistry.addRecipe(new ItemStack(rGasMask, 1), "###",
                "#$#", "###", '$', rFFieldAL, '#', rATaint);
        GameRegistry.addRecipe(new ItemStack(oGasMask, 1), "###",
                "#$#", "###", '$', oFFieldAL, '#', oATaint);
        GameRegistry.addRecipe(new ItemStack(yGasMask, 1), "###",
                "#$#", "###", '$', yFFieldAL, '#', yATaint);
        GameRegistry.addRecipe(new ItemStack(lGasMask, 1), "###",
                "#$#", "###", '$', lFFieldAL, '#', lATaint);
        GameRegistry.addRecipe(new ItemStack(gGasMask, 1), "###",
                "#$#", "###", '$', gFFieldAL, '#', gATaint);
        GameRegistry.addRecipe(new ItemStack(cGasMask, 1), "###",
                "#$#", "###", '$', cFFieldAL, '#', cATaint);
        GameRegistry.addRecipe(new ItemStack(bGasMask, 1), "###",
                "#$#", "###", '$', bFFieldAL, '#', bATaint);
        GameRegistry.addRecipe(new ItemStack(pGasMask, 1), "###",
                "#$#", "###", '$', pFFieldAL, '#', pATaint);
        GameRegistry.addRecipe(new ItemStack(rFField, 4), "###",
                "#$#", "###", '$', rTaint2, '#', rATaint);
        GameRegistry.addRecipe(new ItemStack(oFField, 4), "###",
                "#$#", "###", '$', oTaint2, '#', oATaint);
        GameRegistry.addRecipe(new ItemStack(yFField, 4), "###",
                "#$#", "###", '$', yTaint2, '#', yATaint);
        GameRegistry.addRecipe(new ItemStack(lFField, 4), "###",
                "#$#", "###", '$', lTaint2, '#', lATaint);
        GameRegistry.addRecipe(new ItemStack(gFField, 4), "###",
                "#$#", "###", '$', gTaint2, '#', gATaint);
        GameRegistry.addRecipe(new ItemStack(cFField, 4), "###",
                "#$#", "###", '$', cTaint2, '#', cATaint);
        GameRegistry.addRecipe(new ItemStack(bFField, 4), "###",
                "#$#", "###", '$', bTaint2, '#', bATaint);
        GameRegistry.addRecipe(new ItemStack(pFField, 4), "###",
                "#$#", "###", '$', pTaint2, '#', pATaint);
        GameRegistry.addRecipe(new ItemStack(rFFieldAL, 4), "###",
                "#$#", "###", '$', rTaint2, '#', rFField);
        GameRegistry.addRecipe(new ItemStack(oFFieldAL, 4), "###",
                "#$#", "###", '$', oTaint2, '#', oFField);
        GameRegistry.addRecipe(new ItemStack(yFFieldAL, 4), "###",
                "#$#", "###", '$', yTaint2, '#', yFField);
        GameRegistry.addRecipe(new ItemStack(lFFieldAL, 4), "###",
                "#$#", "###", '$', lTaint2, '#', lFField);
        GameRegistry.addRecipe(new ItemStack(gFFieldAL, 4), "###",
                "#$#", "###", '$', gTaint2, '#', gFField);
        GameRegistry.addRecipe(new ItemStack(cFFieldAL, 4), "###",
                "#$#", "###", '$', cTaint2, '#', cFField);
        GameRegistry.addRecipe(new ItemStack(bFFieldAL, 4), "###",
                "#$#", "###", '$', bTaint2, '#', bFField);
        GameRegistry.addRecipe(new ItemStack(pFFieldAL, 4), "###",
                "#$#", "###", '$', pTaint2, '#', pFField);
    }
}
