package com.nguyennt.animal.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AnimalModel implements Parcelable {
    public boolean liked;
    public int resource;

    public  String name;
    public  String detail;
    public  int photo;

    public AnimalModel(boolean like, int r, String name, String detail, int photo) {
        this.liked = like;
        this.resource = r;
        this.name = name;
        this.detail = detail;
        this.photo = photo;
    }

    public AnimalModel(){}

    public boolean isLiked() {
        return liked;
    }

    public int getResource() {
        return resource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
