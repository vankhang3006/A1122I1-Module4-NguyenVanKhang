package com.codegym.model;

public class User_Permission {
    private int user_id;
    private int method_id;

    public User_Permission() {
    }

    public User_Permission(int user_id, int method_id) {
        this.user_id = user_id;
        this.method_id = method_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMethod_id() {
        return method_id;
    }

    public void setMethod_id(int method_id) {
        this.method_id = method_id;
    }
}
