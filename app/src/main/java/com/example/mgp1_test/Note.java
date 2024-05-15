package com.example.mgp1_test;

import java.io.Serializable;
//References:
//https://stackoverflow.com/questions/67219782/how-to-make-notes-section-in-an-app-already-created-in-android-studio
//https://www.youtube.com/watch?v=or_pH92l-IQ
public class Note implements Serializable {
    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Note() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
