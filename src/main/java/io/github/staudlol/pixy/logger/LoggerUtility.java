package io.github.staudlol.pixy.logger;

import io.github.staudlol.pixy.chat.CC;
import org.bukkit.Bukkit;

public class LoggerUtility {

    /**
     * Broadcast a message to the console.
     *
     * @param message the message.
     */

    public static void sendMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(CC.translate(message));
    }
}
