package mods.me.minecraft4455.dmt2.core.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import mods.me.minecraft4455.dmt2.core.lib.Reference;
import cpw.mods.fml.common.FMLLog;

public class LogHelper {

    private static Logger eeLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        eeLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        eeLogger.log(logLevel, message);
    }

}