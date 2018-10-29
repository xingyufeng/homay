package com.homay.modules.test.model;

import java.util.List;

public class Movie {
    private String title;
    private List<Subjects> subjects;

    public Movie() {

    }
    public Movie(String title, List<Subjects> subjects) {
        this.title = title;
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }
}
