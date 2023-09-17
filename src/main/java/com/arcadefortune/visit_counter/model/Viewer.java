package com.arcadefortune.visit_counter.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "Viewers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viewer {
    @Id
    private long id; // the position in which the viewer has entered its IP address
    private String ip;
    private LocalDate date;
    private int viewCount;

    public Viewer(String ip) {
        this.ip = ip;
        this.date = LocalDate.now();
        this.viewCount = 0;
    }
}
