package com.sorapp.retrofit_ezample.model;

import com.google.gson.annotations.SerializedName;

public class user_model
{
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("family")
    private String family;
    @SerializedName("username")
    private String username;

    public user_model(int id, String name, String family, String username)
    {
        this.id = id;
        this.name = name;
        this.family = family;
        this.username = username;
    }

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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
