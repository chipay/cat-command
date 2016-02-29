package org.chipay.cat.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatFacts {

    private boolean success;
    private List<String> facts;

    public CatFacts() {
        this.facts = new ArrayList<>();
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return this.success;
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
