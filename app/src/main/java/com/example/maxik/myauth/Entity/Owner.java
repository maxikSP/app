package com.example.maxik.myauth.Entity;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.Transient;

/**
 * Created by maxik on 5/20/15.
 */

@Parcel
public class Owner {

    @Transient
    @SerializedName("id")
    private int id;

    @Transient
    @SerializedName("login")
    private String login;

    @Transient
    @SerializedName("avatar_url")
    private String avatarUrl;

    @Transient
    @SerializedName("gravatar_id")
    private String gravatarId;

    @Transient
    @SerializedName("url")
    private String url;

    @Transient
    @SerializedName("html_url")
    private String htmlUrl;

    @Transient
    @SerializedName("followers_url")
    private String followersUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }
}
