package com.example.mapsapi.model;

public class dataHome {
    private String key;
    private String judul;

    public dataHome(String key, String judul) {
        this.key = key;
        this.judul = judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getJudul() {
        return judul;
    }

    public String getKey() {
        return key;
    }
}
