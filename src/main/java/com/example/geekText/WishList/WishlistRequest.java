package com.example.geekText.WishList;

public class WishlistRequest {
    private String name;
    private long userId;

    public WishlistRequest() {}

    public WishlistRequest(String name, long userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
