package com.githubtools.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimePeriodReturnDTO {
    @JsonProperty("start")
    private final String start;

    @JsonProperty("end")
    private final String end;

    @JsonProperty("display_label")
    private final String displayLabel;

    public TimePeriodReturnDTO(String start, String end, String displayLabel){
        this.start = start;
        this.end = end;
        this.displayLabel = displayLabel;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }
}
