package com.nguyennt.animal;


import android.os.Parcel;
import android.os.Parcelable;

public class AnimalModel implements Parcelable {
    public boolean liked;
    public int resource;

    public final String name;
    public final String detail;
    public final int photo;

    public AnimalModel(boolean like, int r, String name, String detail, int photo) {
        this.liked = like;
        this.resource = r;
        this.name = name;
        this.detail = detail;
        this.photo = photo;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
