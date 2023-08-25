package ng5m.kowal.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AnvilListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.ANVIL) {
            e.setCancelled(true);
            p.openInventory(KowadloInv.getInv().getInventory());

        }

    }

}
