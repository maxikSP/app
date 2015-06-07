package com.example.maxik.myauth.Entity;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by maxik on 06.06.15.
 */

@Parcel
public class Plan {

    @SerializedName("name")
    private String name;

    @SerializedName("space")
    private int space;

    @SerializedName("collaborators")
    private int collaborators;

    @SerializedName("private_repos")
    private int privateRepos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(int collaborators) {
        this.collaborators = collaborators;
    }

    public int getPrivateRepos() {
        return privateRepos;
    }

    public void setPrivateRepos(int privateRepos) {
        this.privateRepos = privateRepos;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                ", space=" + space +
                ", collaborators=" + collaborators +
                ", privateRepos=" + privateRepos +
                '}';
    }
}
