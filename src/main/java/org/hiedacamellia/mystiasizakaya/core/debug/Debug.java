package org.hiedacamellia.mystiasizakaya.core.debug;


import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.hiedacamellia.mystiasizakaya.Config;
import org.hiedacamellia.mystiasizakaya.MystiasIzakaya;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Debug {

    private static String prefix = "[§a夜雀食堂§r]";
    private static Boolean debugConfig = Config.debug;
    private static Logger logger = LoggerFactory.getLogger(MystiasIzakaya.MODID);


    public Debug(){
    }

    public static void info(String message){
        logger.info(message);
    }

    public static void info(String message, Throwable t){
        logger.info(message,t);
    }

    public static void info(String format, Object arg) {
        logger.info(format, arg);
    }

    public static void debug(String message){
        if(debugConfig)
            logger.debug(message);
    }

    public static void debug(String message, Throwable t){
        if(debugConfig)
            logger.debug(message,t);
    }

    public static void debug(String format, Object arg) {
        if(debugConfig)
            logger.debug(format, arg);
    }

    public static void error(String message){
        logger.error(message);
    }

    public static void error(String message, Throwable t){
        logger.error(message,t);
    }

    public static void error(String format, Object arg) {
        logger.error(format, arg);
    }

    public static void warn(String message){
        logger.warn(message);
    }

    public static void warn(String message, Throwable t){
        logger.warn(message,t);
    }

    public static void warn(String format, Object arg) {
        logger.warn(format, arg);
    }

    public static void trace(String message){
        logger.trace(message);
    }

    public static void trace(String message, Throwable t){
        logger.trace(message,t);
    }

    public static void trace(String format, Object arg) {
        logger.trace(format, arg);
    }

    public static Logger getLogger(){
        return logger;
    }

    //客户端调试信息
    public static void send(String string) {
        if (FMLEnvironment.dist.isClient()) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && debugConfig) {
                mc.player.sendSystemMessage(Component.literal(prefix + string));
            }
        }
    }

    //服务端调试信息
    public static void send(String string, Player player) {
        Level level = player.level();
        if(!level.isClientSide && debugConfig) {
            player.sendSystemMessage(Component.literal(prefix  + string));
        }
    }
}

