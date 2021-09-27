package com.company;

import javax.security.auth.login.AccountException;

public class Followers implements IObserver {
    private Integer followers_id;
    private IGAccount account;

    public Followers(Integer followers_id, IGAccount account) {
        this.followers_id = followers_id;
        this.account = account;
        account.add(this);
    }

    @Override
    public void update() {
        Post newPost = account.getTodayPosts();
        System.out.println("Follower with = " + followers_id + "accepted new Post");
        Video newVideo = account.getTodayVideos();
        System.out.println("Follower with = " + followers_id + "accepted new Video");
    }
}
