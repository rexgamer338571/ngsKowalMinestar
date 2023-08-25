package ng5m.kowal;

import ng5m.kowal.util.Lore;
import ng5m.kowal.spigui.buttons.SGButton;
import ng5m.kowal.spigui.item.ItemBuilder;
import ng5m.kowal.spigui.menu.SGMenu;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIUtils {
  public static void spawnPane(SGMenu menu, String color) {
    menu.addButton(new SGButton(new ItemBuilder(Material.valueOf(color+"_STAINED_GLASS_PANE")).name("&0 ").build()));
  }

  public static void addAnotherItem(SGMenu menu, Material material, String name, String[] lore, Inventory openLater, int panes) {
    for (int i = 0; i<panes; i++) {
      SGButton btn = new SGButton(
        new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).name("&0 ").build()
      );
      menu.addButton(btn);
    }

    SGButton btn2 = new SGButton(
      new ItemBuilder(material).name(name).lore(lore).build()
    ).withListener((InventoryClickEvent e) -> {
      e.getWhoClicked().openInventory(openLater);
    });
    menu.addButton(btn2);
  }

  public static void addItemNoListener(SGMenu menu, Material material, String name, String[] lore, int panes) {
    for (int i = 0; i<panes; i++) {
      SGButton btn = new SGButton(
        new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).name("&0 ").build()
      );
      menu.addButton(btn);
    }
    SGButton btn2 = new SGButton(
      new ItemBuilder(material).name(name).lore(lore).build()
    );
    menu.addButton(btn2);
  }
}
