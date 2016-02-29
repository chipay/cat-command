package org.chipay.cat.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatFacts {

    private final String SUCCESS = "success";

    private String success;
    private List<String> facts;

    public CatFacts() {
        this.facts = new ArrayList<>();
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public boolean success() {
        return SUCCESS.equals(this.success);
    }

    public List<String> getFacts() {
        return facts;
    }

    public void addFact(String fact) {
        this.facts.add(fact);
    }

    @Override
    public String toString() {
        return "CatFacts{" +
                "success='" + success + '\'' +
                ", facts=" + facts +
                '}';
    }
}
