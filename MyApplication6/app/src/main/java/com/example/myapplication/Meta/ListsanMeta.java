package com.example.myapplication.Meta;

public class ListsanMeta {
    int avatarSan;
    String nameSan;
    String adress;

    public ListsanMeta(int avatarSan, String nameSan, String adress) {
        this.avatarSan = avatarSan;
        this.nameSan = nameSan;
        this.adress = adress;
    }

    public int getAvatarSan() {
        return avatarSan;
    }

    public void setAvatarSan(int avatarSan) {
        this.avatarSan = avatarSan;
    }

    public String getNameSan() {
        return nameSan;
    }

    public void setNameSan(String nameSan) {
        this.nameSan = nameSan;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
