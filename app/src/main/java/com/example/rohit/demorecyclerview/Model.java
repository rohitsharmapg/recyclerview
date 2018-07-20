package com.example.rohit.demorecyclerview;

import io.realm.RealmObject;

public class Model extends RealmObject {

    private String image;

    public Model() {
    }

    public Model(String image) {
        this.image = image;

    }

    public String getImage() {
        return image;
    }


}
