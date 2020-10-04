package com.shrimali.eduapp;

public class MemoryMaps {

    private  int MemoID;
    private  String name;
    private String   mention;
    private byte[] image;

    public MemoryMaps(int memoID, String name, String mention, byte[] image) {
        MemoID = memoID;
        this.name = name;
        this.mention = mention;
        this.image = image;
    }

    public int getMemoID() {
        return MemoID;
    }

    public void setMemoID(int memoID) {
        MemoID = memoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
