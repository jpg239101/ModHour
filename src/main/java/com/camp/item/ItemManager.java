package com.camp.item;
 
import net.minecraftforge.fml.common.registry.GameRegistry;
 
public class ItemManager {
 
    public static CustomItem customItem;
    public static CustomAmmo customAmmo;
    public static Peridot peridot;
    
    
    public static void mainRegistry() {
        initializeItem();
        registerItem();
    }
 
    public static void initializeItem() {
        customItem = new CustomItem();
        customAmmo = new CustomAmmo();
        peridot = new Peridot();
    }
 
    public static void registerItem() {
        GameRegistry.registerItem(customItem, customItem.name);
        GameRegistry.registerItem(customAmmo, customAmmo.name);
        GameRegistry.registerItem(peridot, peridot.name);
    }
 
}
