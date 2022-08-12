package com.nguyennt.animal;


public class AnimalModel {
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
}
