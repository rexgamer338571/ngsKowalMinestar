package ng5m.kowal;

import ng5m.kowal.Kowal;
import ng5m.kowal.GUIUtils;
import ng5m.kowal.util.TextUtil;
import ng5m.kowal.spigui.buttons.SGButton;
import ng5m.kowal.spigui.item.ItemBuilder;
import ng5m.kowal.spigui.menu.SGMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class KowadloInv {

    public static SGMenu getInv() {
        SGMenu inv = Boxpvppluginpack.spiGUI.create("&6&lKowadło", 5);
        String[] a = new String[]{"yellow","orange","white","white","","white","white","orange","yellow","orange","","","","","","","","orange","white","",""};
        String[] b = new String[]{"","","white","orange","","","","","","","","orange","yellow","orange","white","white","","white","white","orange","yellow"};

        for (int i=0;i<a.length;i++) {
            if (a[i]=="")
                inv.addButton(new SGButton(new ItemBuilder(Material.AIR).build()));
            else
                GUIUtils.spawnPane(inv, a[i]);
        }

        inv.addButton(new SGButton(new ItemBuilder(Material.ANVIL).name("&7&lKowadło").lore("","","&eKliknij, aby otworzyć kowadło").build()).withListener((InventoryClickEvent e) -> {
            Player p = (Player) e.getWhoClicked();
            Inventory inva = Bukkit.createInventory(p, InventoryType.ANVIL);
            p.openInventory(inva);
        }));
        inv.addButton(new SGButton(new ItemBuilder(Material.EXPERIENCE_BOTTLE).name("&7&lNapraw przedmiot").lore("","","&eKliknij, aby naprawić przedmiot").build()).withListener((InventoryClickEvent e) -> {
            Player p = (Player) e.getWhoClicked();
            p.getInventory().getItemInMainHand().setDurability((short)0);
            p.sendTitle(TextUtil.fixColor("&7Kowal"),"&eNaprawiono przedmiot");

            p.closeInventory();
        }));
        inv.addButton(new SGButton(new ItemBuilder(Material.SMITHING_TABLE).name("&7&lWymień na diamentowy przedmiot").lore("","","&eKliknij, aby zamienić netherytowy przedmiot na diamentowy").build()).withListener((InventoryClickEvent e) -> {
            Player p = (Player) e.getWhoClicked();
            ItemStack pimh = p.getInventory().getItemInMainHand();

            List<String> n = Arrays.asList(
                    "NETHERITE_SWORD",
                    "NETHERITE_AXE",
                    "NETHERITE_HOE",
                    "NETHERITE_HELMET",
                    "NETHERITE_CHESTPLATE",
                    "NETHERITE_LEGGINGS",
                    "NETHERITE_BOOTS",
                    "NETHERITE_SHOVEL",
                    "NETHERITE_PICKAXE");

            if (!n.contains(pimh.getType().name())) {
                p.sendTitle(TextUtil.fixColor("&7Kowal"), TextUtil.fixColor("&cPrzedmiot w twojej ręce nie jest netherytowy!"));
            }

            ItemStack d = new ItemStack(Material.valueOf(pimh.getType().name().replace("NETHERITE","DIAMOND")));
            d.setItemMeta(pimh.getItemMeta());

            p.getInventory().setItemInMainHand(d);
            p.sendTitle(TextUtil.fixColor("&7Kowal"), TextUtil.fixColor("&eZamieniono przedmiot"));

            p.closeInventory();
        }));

        for (int i=0;i<b.length;i++) {
            if (b[i]=="")
                inv.addButton(new SGButton(new ItemBuilder(Material.AIR).build()));
            else
                GUIUtils.spawnPane(inv, b[i]);
        }

        return inv;
    }

}
