package com.example.ss.gameforkids;

/**
 * Created by ss on 2017-09-12.
 */

public class ListViewPuzzle {
    private int img_category;
    private String st_category;
    public ListViewPuzzle(int img_category, String st_category){
        this.img_category = img_category;
        this.st_category = st_category;
    }

    public int getImg_category() {
        return img_category;
    }

    public String getSt_category() {
        return st_category;
    }
}
