package mods.me.minecraft4455.dmt2.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

import net.minecraftforge.common.Configuration;

public class Dmt2Config {
    @Retention(RetentionPolicy.RUNTIME)
    private static @interface CfgId {
        public boolean block() default false;
    }
    @Retention(RetentionPolicy.RUNTIME)
    private static @interface CfgBool {}

    //example use
    //public static @CfgId int itemId = 12000;
    //public static @CfgId(block=true) int blockId = 350;
    //public static @CfgBool boolean booleanConfig = false;
    public static @CfgId(block=true) int WriterID = 4000;
    public static @CfgId(block=true) int HullConstructerID = 4001;
    public static @CfgId(block=true) int WorkBenchWoodenHullID = 4002;

    public static void  load(Configuration config) {
        try {
            config.load();
            Field[] fields = Dmt2Config.class.getFields();
            for(Field field : fields) {
                CfgId annotation = field.getAnnotation(CfgId.class);
                if(annotation != null) {
                    int id = field.getInt(null);
                    if(annotation.block()){
                        id = config.getBlock(field.getName(), id).getInt();
                    }else{
                        id = config.getItem(field.getName(), id).getInt();
                    }
                    field.setInt(null, id);
                } else {
                    if(field.isAnnotationPresent(CfgBool.class)){
                        boolean bool = field.getBoolean(null);
                        bool = config.get(Configuration.CATEGORY_GENERAL,
                                field.getName(), bool).getBoolean(bool);
                        field.setBoolean(null, bool);
                    }
                }
            }
        } catch(Exception e) {
            //failed to load configs log
        } finally {
            config.save();
        }
    }

}