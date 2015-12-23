package com.example.saifi45.labhle.items;

import android.content.res.Resources;

import java.util.ArrayList;


public  class    Painting {

    private final String imageId;
    private final String title;
    private final String idss;

    public Painting(String imageId, String title, String idss) {
        this.imageId = imageId;
        this.title = title;

        this.idss = idss;
    }

    public String getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }
    public String getIdss() {
        return idss;
    }


    public static Painting[] getAllPaintingssam(Resources res, ArrayList<String> names, ArrayList<String> images1, ArrayList<String> idarray) {


        ArrayList<String> titles=new ArrayList<String>();
        titles=names;


        ArrayList<String> ids=new ArrayList<String>();
        ids = idarray ;
       // String[] locations = res.getStringArray(R.array.paintings_locations);

        ArrayList<String> images=new ArrayList<String>();
        images = images1;

        Painting[] paintings = new Painting[names.size()];

        for (int i = 0; i < names.size(); i++) {
            paintings[i] = new Painting(images.get(i), titles.get(i),ids.get(i));
        }

        return paintings;
    }



    public static Painting[] getAllPaintingssamGYM(Resources res, String[] names, String[] images1, String[] idarray) {

        String[] titles = names ;

        String[] ids = idarray ;
        // String[] locations = res.getStringArray(R.array.paintings_locations);
        String[] images = images1;


        Painting[] paintings = new Painting[names.length];

        for (int i = 0; i < names.length; i++) {
            paintings[i] = new Painting(images[i], titles[i],ids[i]);
        }

        return paintings;
    }



   /* public static Painting getAllPaintingssam(Resources resources, ArrayList<String> name11) {
            String[] stockArr = new String[name11.size()];
            stockArr = name11.toArray(stockArr);
        return paintings;
    }   */
}
