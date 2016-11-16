package com.example.wfrelic;

/**
 * Created by hackeru on 13/11/2016.
 */

public class Item {
    String name;
    String part;
    String rarity;
    String relics;
    int plat;
    int ducat;
    int vaulted;

    public Item()
    {
        plat = -1;
    }

    public Item(String name, String part, String rarity, String relics, int ducat, int vaulted) {
        this.name = name;
        this.part = part;
        this.rarity = rarity;
        this.relics = relics;
        this.plat = -1;
        this.ducat = ducat;
        this.vaulted = vaulted;
    }

    public Item(String name, String part, String rarity, String relics, int ducat, int vaulted, int plat) {
        this.name = name;
        this.part = part;
        this.rarity = rarity;
        this.relics = relics;
        this.plat = plat;
        this.ducat = ducat;
        this.vaulted = vaulted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getRelics() {
        return relics;
    }

    public void setRelics(String relics) {
        this.relics = relics;
    }

    public int getPlat() {
        return plat;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }

    public int getDucat() {
        return ducat;
    }

    public void setDucat(int ducat) {
        this.ducat = ducat;
    }

    public int getVaulted() {
        return vaulted;
    }

    public void setVaulted(int vaulted) {
        this.vaulted = vaulted;
    }

}
