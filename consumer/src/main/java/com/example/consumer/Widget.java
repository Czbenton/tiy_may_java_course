package com.example.consumer;

import java.time.LocalDate;

/**
 * Created by Zach on 8/2/17.
 */
public class Widget {
    String name;
    String version;
    LocalDate releaseDate;

    public Widget() {
    }

    public Widget(String name, String version, LocalDate releaseDate) {
        this.name = name;
        this.version = version;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
