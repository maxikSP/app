package com.example.maxik.myauth.Entity;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;
import org.parceler.Transient;

/**
 * Created by maxik on 25.05.15.
 */
@Parcel
public class Repo {

    @Transient
    @SerializedName("id")
    private int id;

    @Transient
    @SerializedName("name")
    private String name;

    @Transient
    @SerializedName("full_name")
    private String fullName;

    @Transient
    @SerializedName("owner")
    private Owner owner;

    @Transient
    @SerializedName("private")
    private boolean isPrivate;

    @Transient
    @SerializedName("html_url")
    private String htmlUrl;

    @Transient
    @SerializedName("description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
