package ng5m.kowal;

import ng5m.kowal.listeners.AnvilListener;
import ng5m.kowal.commands.KowalCmd;
import ng5m.kowal.spigui.SpiGUI;

import org.bukkit.plugin.java.JavaPlugin;

import ng5m.kowal.commands.Kowal;

public final class Kowal extends JavaPlugin {
  public static SpiGUI spiGUI;

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(new AnvilListener(), this);

    getCommand("kowal").setExecutor(new KowalCmd());
  }

  @Override
  public void onDisable() {
  }
}
