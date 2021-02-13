package com.example.android.miwok;

public class word {
    private String hindi;
    private String english;
    private int imageid=NO_IMAGE_PROVIDED;
    private int soundid;
    private static final int NO_IMAGE_PROVIDED = -1;
    public word(String a,String b,int d)
    {
        hindi=a;
        english=b;
        soundid=d;
    }
    public word(String a,String b,int x,int d)
    {
        hindi=a;
        english=b;
        imageid=x;
        soundid=d;
    }
    public String gethindi()
    {
        return hindi;
    }
    public String getenglish()
    {
        return english;
    }
    public int getImageid(){return imageid;}
    public int getsound(){return soundid;}
    public boolean hasImage() {
        return imageid != NO_IMAGE_PROVIDED;
    }
}
