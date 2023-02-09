package io.github.staudlol.pixy.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PlayerUtility {

    /**
     * Reset a {@link Player
     *
     * @param player the player.
     */

    public static void reset(Player player) {
        player.setGameMode(GameMode.SURVIVAL);

        player.setHealthScale(player.getMaxHealth());
        player.setFoodLevel(20);
        player.setSaturation(12.8F);

        player.setMaximumNoDamageTicks(20);
        player.setFireTicks(0);
        player.setFireTicks(0);

        player.setFallDistance(0.0F);
        player.setLevel(0);
        player.setExp(0.0F);
        player.setWalkSpeed(0.2F);
        player.setAllowFlight(false);

        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.getInventory().setHeldItemSlot(0);

        for (PotionEffect potionEffect : player.getActivePotionEffects()) {
            player.removePotionEffect(potionEffect.getType());
        }

        player.updateInventory();
    }
}
