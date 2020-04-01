package com.web.testProject.utils;

/**
 * Created by Rus on 02.05.2017.
 */
public class Classes {
    private String name;
    private String description;
    private String trainer;

    public Classes(String name, String description, String trainer) {
        this.name = name;
        this.description = description;
        this.trainer =  trainer;
    }

    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", trainer='" + trainer + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getTrainer(){
        return trainer;
    }

    public String getDescription() {
        return description;
    }

}
