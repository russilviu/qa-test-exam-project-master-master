package com.web.testProject.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by RusS on 4/25/2017.
 */
@Component
public class UrlFactory {

    @Value("http://www.fasttrackit.org/")
    private String fastTrackItAddress;

    public String getHomeUrl() {
        return fastTrackItAddress;
    }

    public String getAccreditationUrl() {
        return fastTrackItAddress + "/acreditare/";
    }

    public String getClassesUrl() {
        return fastTrackItAddress + ("/cursuri/");
    }

    public String getRegistrationUrl() {
        return fastTrackItAddress + "/inscriere/";
    }

    public String getBlogUrl() {
        return fastTrackItAddress + "/blog/";
    }

    public String getAboutUsUrl() {
        return fastTrackItAddress + "/despre/";
    }

    public String getContactUsUrl() {
        return fastTrackItAddress + "/contact/";
    }

}
