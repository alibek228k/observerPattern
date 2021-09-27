package com.company;

import java.util.ArrayList;
import java.util.List;


public class IGAccount implements IObservable{

    List<IObserver> followers;
    List<Post> post;
    List<Video> videos;

    public IGAccount() {
        this.followers = new ArrayList<>();
        this.post = new ArrayList<>();
        this.videos = new ArrayList<>();
    }

    public void publishPost(Post p1) {
        post.add(p1);
        notify1();
    }

    public void publishVideo(Video v1) {
        videos.add(v1);
        notify1();
    }

    public Post getTodayPosts() {
        int lastVideo = post.size() - 1;
        return post.get(lastVideo);
    }

    public Video getTodayVideos() {
        int lastVideo = videos.size() - 1;
        return videos.get(lastVideo);
    }

    @Override
    public void add(IObserver observer) {
        this.followers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        this.followers.remove(observer);
    }

    @Override
    public void notify1() {
        for(IObserver observer: followers) {
            observer.update();
        }
    }
}
