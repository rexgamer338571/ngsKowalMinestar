package ng5m.kowal.util;

public class Lore {
  public static String[] l(String priceBuy, String priceSell) {
    String color = "&a";
    if (priceSell.equals("")) {
      color = "&c";
      priceSell = "❌";
    }
    return new String[]{"&8| &7Cena kupna&8: &a" + priceBuy, "&8| &7Cena sprzedaży&8: " + color + priceSell, "", "&8| &7Kliknij &elewym &7 żeby kupić!", "&8| &7Kliknij &eSCROLL &7żeby wszystko sprzedać!", "&8| &7Kliknij &eprawym &7żeby sprzedać!"};
  }
}
