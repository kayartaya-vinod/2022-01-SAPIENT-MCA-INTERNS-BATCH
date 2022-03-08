package com.sapient.entity;

public class Movie {
    private String imdbID;
    private String title;
    private String genre;
    private int runningTime; // in minutes

    // no-arg or default consturctor
    public Movie() {
    }

    // overloaded or parameterized constructor
    public Movie(String imdbID, String title, String genre, int runningTime) {
        this.imdbID = imdbID;
        this.title = title;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        return "Movie [genre=" + genre + ", imdbID=" + imdbID + ", runningTime=" + runningTime + ", title=" + title
                + "]";
    }

}
