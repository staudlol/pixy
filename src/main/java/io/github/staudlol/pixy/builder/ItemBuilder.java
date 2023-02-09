package io.github.staudlol.pixy.builder;

import lombok.Data;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

@Data
public class ItemBuilder {

    private final ItemStack itemStack;

    /**
     * Constructor to create a new {@link ItemBuilder} instance.
     *
     * @param material the material.
     */

    public ItemBuilder(Material material) {
        this(material, 1);
    }

    /**
     * Constructor to create a new {@link ItemBuilder} instance.
     *
     * @param material the material.
     * @param amount the amount.
     */

    public ItemBuilder(Material material, int amount) {
        this.itemStack = new ItemStack(material, amount);
    }

    /**
     * Constructor to create a new {@link ItemBuilder} instance.
     *
     * @param material the material.
     * @param amount the amount.
     * @param value the value.
     */

    public ItemBuilder(Material material, int amount, short value) {
        this.itemStack = new ItemStack(material, amount, value);
    }

    /**
     * Set the name of a {@link ItemStack}.
     *
     * @param name the name.
     * @return the item.
     */

    public ItemBuilder name(String name) {
        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setDisplayName(name);

        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Set the lore of a {@link ItemStack}.
     *
     * @param lore the lore.
     * @return the item.
     */

    public ItemBuilder lore(String... lore) {
        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setLore(Arrays.asList(lore));

        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Set the data of a {@link ItemStack}.
     *
     * @param data the data.
     * @return the item.
     */

    public ItemBuilder data(byte data) {
        this.itemStack.setDurability(data);
        return this;
    }

    /**
     * Add a glow to a {@link ItemStack}.
     *
     * @return the item.
     */

    public ItemBuilder glow() {
        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addEnchant(org.bukkit.enchantments.Enchantment.DURABILITY, 1, true);
        itemMeta.addItemFlags(org.bukkit.inventory.ItemFlag.HIDE_ENCHANTS);

        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Add an enchantment to a {@link ItemStack}.
     *
     * @param enchantment the enchantment.
     * @param level the level.
     * @return the item.
     */

    public ItemBuilder enchantment(Enchantment enchantment, int level) {
        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addEnchant(enchantment, level, true);

        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Remove an enchantment from a {@link ItemStack}.
     *
     * @param enchantment the enchantment.
     * @return the item.
     */

    public ItemBuilder removeEnchantment(Enchantment enchantment) {
        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.removeEnchant(enchantment);

        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * Set the {@link Color} of a {@link ItemStack}.
     *
     * @param color the color.
     * @return the item.
     */

    public ItemBuilder leatherArmor(Color color) {
        final LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) this.itemStack.getItemMeta();
        leatherArmorMeta.setColor(color);

        this.itemStack.setItemMeta(leatherArmorMeta);
        return this;
    }

    /**
     * Set the skull owner of a {@link ItemStack}.
     *
     * @param skullOwner the skull owner.
     * @return the item.
     */

    public ItemBuilder skull(String skullOwner) {
        try {
            final SkullMeta skullMeta = (SkullMeta) this.itemStack.getItemMeta();
            skullMeta.setOwner(skullOwner);
            this.itemStack.setItemMeta(skullMeta);
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return this;
    }

    public ItemStack build() {
        return this.itemStack;
    }
}
