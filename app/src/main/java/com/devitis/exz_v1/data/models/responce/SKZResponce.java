package com.devitis.exz_v1.data.models.responce;

import com.devitis.exz_v1.data.models.KIPModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diana on 15.04.2019.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class SKZResponce {

    private int count;
    private String next;
    private String previous;

    private List<KIPModel> result = new ArrayList<>();

    public List<KIPModel> getResult() {
        return result;
    }

    public void setResult(List<KIPModel> result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
