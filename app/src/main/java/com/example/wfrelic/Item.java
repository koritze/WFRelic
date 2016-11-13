package com.example.wfrelic;

/**
 * Created by hackeru on 13/11/2016.
 */

public class Item {
    String name;
    int bmin;
    int smin;
    int ducats;
    Relic[] source;

    public Item(String name, int bmin, int smin, int ducats) {
        this.name = name;
        this.bmin = bmin;
        this.smin = smin;
        this.ducats = ducats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBmin() {
        return bmin;
    }

    public void setBmin(int bmin) {
        this.bmin = bmin;
    }

    public int getSmin() {
        return smin;
    }

    public void setSmin(int smin) {
        this.smin = smin;
    }

    public int getDucats() {
        return ducats;
    }

    public void setDucats(int ducats) {
        this.ducats = ducats;
    }
}
