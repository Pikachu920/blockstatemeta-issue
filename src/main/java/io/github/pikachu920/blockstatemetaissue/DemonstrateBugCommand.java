package io.github.pikachu920.blockstatemetaissue;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.jetbrains.annotations.NotNull;

public class DemonstrateBugCommand implements CommandExecutor {

    private ItemStack createGlowingSign() {
        ItemStack signItem = new ItemStack(Material.OAK_SIGN);
        BlockStateMeta signMeta = (BlockStateMeta) signItem.getItemMeta();
        Sign signState = (Sign) signMeta.getBlockState();
        signState.getSide(Side.FRONT).setGlowingText(true);
        signState.getSide(Side.BACK).setGlowingText(true);
        signState.update();
        signMeta.setBlockState(signState);
        signItem.setItemMeta(signMeta);
        return signItem;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        ItemStack glowingSign = createGlowingSign();
        Sign glowingSignState = (Sign) ((BlockStateMeta) glowingSign.getItemMeta()).getBlockState();
        Bukkit.broadcast(Component.text("Is the front glowing? " + glowingSignState.getSide(Side.FRONT).isGlowingText()));
        Bukkit.broadcast(Component.text("Is the back glowing? " + glowingSignState.getSide(Side.BACK).isGlowingText()));
        if (commandSender instanceof InventoryHolder inventoryHolder) {
            inventoryHolder.getInventory().addItem(glowingSign);
        }
        return true;
    }
}
