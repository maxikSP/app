package com.example.maxik.myauth.Entity;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.Transient;

/**
 * Created by maxik on 5/20/15.
 */
@Parcel
public class RestError {

    @Transient
    @SerializedName("code")
    private Integer code;

    @Transient
    @SerializedName("error_message")
    private String strMessage;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStrMessage() {
        return strMessage;
    }

    public void setStrMessage(String strMessage) {
        this.strMessage = strMessage;
    }
}
