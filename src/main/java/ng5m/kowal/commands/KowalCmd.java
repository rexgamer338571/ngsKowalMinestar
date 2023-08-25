package ng5m.kowal.commands;

import ng5m.kowal.KowadloInv;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kowal implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player) sender;
      
      p.openInventory(KowadloInv.getInv().getInventory());
    }
    return true;
  }
}
