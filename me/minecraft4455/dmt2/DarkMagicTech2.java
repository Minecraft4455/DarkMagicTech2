package mods.me.minecraft4455.dmt2;

import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;

import mods.me.minecraft4455.dmt2.block.BlockHullConstructer;
import mods.me.minecraft4455.dmt2.block.BlockWorkBenchWoodenHull;
import mods.me.minecraft4455.dmt2.block.BlockWriter;
import mods.me.minecraft4455.dmt2.core.CommonProxy;
import mods.me.minecraft4455.dmt2.core.Dmt2Config;
import mods.me.minecraft4455.dmt2.core.GuiHandler;
import mods.me.minecraft4455.dmt2.core.lib.Reference;
import mods.me.minecraft4455.dmt2.entity.EntityDressedZombie;
import mods.me.minecraft4455.dmt2.tileentitys.TileHullConstructer;
import mods.me.minecraft4455.dmt2.tileentitys.TileWriter;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

    @Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
    @NetworkMod(clientSideRequired = true, serverSideRequired = false)
    public class DarkMagicTech2 {
        private GuiHandler guiHandler = new GuiHandler();
        @Instance
        public static DarkMagicTech2 instance;
        @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
        public static CommonProxy proxy;
        public static Logger logger;
        static int startEntityId = 300;
    
        /*
         * Block
         */
        public static Block Writer;
        public static Block WorkBenchWoodenHull;
        public static Block HullConstructer;
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
            logger = Logger.getLogger(Reference.MOD_ID);
            logger.setParent(FMLLog.getLogger());

            Configuration config = new Configuration(
                          event.getSuggestedConfigurationFile());
            Dmt2Config.load(config);
        }
        
        @Init
        public void init(FMLInitializationEvent event) {
            /*
             * Register things
             */
            NetworkRegistry.instance().registerGuiHandler(instance, guiHandler);
            /*
             * Blocks
             */
            Writer = new BlockWriter(Dmt2Config.WriterID);
            GameRegistry.registerTileEntity(TileWriter.class, "Writer");
            GameRegistry.registerBlock(Writer, "WorkBench Creator");
            LanguageRegistry.addName(Writer,  "WorkBench Creator");
            WorkBenchWoodenHull = new BlockWorkBenchWoodenHull(Dmt2Config.WorkBenchWoodenHullID);
            GameRegistry.registerBlock(WorkBenchWoodenHull, "WorkBenchWoodenHull");
            LanguageRegistry.addName(WorkBenchWoodenHull, "WorkBench Wooden Hull");
            HullConstructer = new BlockHullConstructer(Dmt2Config.HullConstructerID);
            GameRegistry.registerTileEntity(TileHullConstructer.class, "HullConstructer");
            GameRegistry.registerBlock(HullConstructer, "HullConstructer");
            LanguageRegistry.addName(HullConstructer, "Hull Constructer");
            /*
             * Recipes
             */
            GameRegistry.addRecipe(new ItemStack(Writer), " B ", "WCW", "SWS", 'S', Item.stick, 'C', Block.workbench, 'B', Item.book, 'W', Block.planks);
            
            /*
             * Mobs
             */
            EntityRegistry.registerModEntity(EntityDressedZombie.class, "DressedZombie", 1, this, 80, 3, true);
            EntityRegistry.addSpawn(EntityDressedZombie.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland);
            LanguageRegistry.instance().addStringLocalization("entity.DMT2.DressedZombie.name", "Dressed Zombie");
            registerEntityEgg(EntityDressedZombie.class, 0xFF2200, 0x1C5904);
            
            proxy.registerRenderThings();
            proxy.registerSoundHandler();
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {

        }
        public static int getUniqueEntityId() 
        {
         do 
         {
          startEntityId++;
         } 
         while (EntityList.getStringFromID(startEntityId) != null);

          return startEntityId;
        }
        
        @SuppressWarnings("unchecked")
        public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
        {
         int id = getUniqueEntityId();
         EntityList.IDtoClassMapping.put(id, entity);
         EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
        }
}

