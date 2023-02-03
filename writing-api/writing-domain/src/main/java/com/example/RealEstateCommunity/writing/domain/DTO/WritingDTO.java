package com.example.RealEstateCommunity.writing.domain.DTO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class WritingDTO {
    private final String title;
    private final Long heartNumber;
    private final String writer;
    private final boolean myHeartChecked;

    public WritingDTO(String title, Long heartNumber, String writer, boolean myHeartChecked) {
        this.title = title;
        this.heartNumber = heartNumber;
        this.writer = writer;
        this.myHeartChecked = myHeartChecked;
    }

}


