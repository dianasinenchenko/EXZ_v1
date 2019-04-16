package com.devitis.exz_v1.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Diana on 15.04.2019.
 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class KIPModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
