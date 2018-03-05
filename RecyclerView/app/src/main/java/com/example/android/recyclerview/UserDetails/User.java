package com.example.android.recyclerview.UserDetails;

import java.util.ArrayList;

/**
 * Created by ramit on 05-Mar-18.
 */

public class User {
    private String userName, userId, date;
    private ArrayList<User> users = new ArrayList<>();

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
