package com.githubtools.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageReturnDTO {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("percentage")
    private final String percentage;

    public LanguageReturnDTO(String name, String percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public String getPercentage() {
        return percentage;
    }

}
