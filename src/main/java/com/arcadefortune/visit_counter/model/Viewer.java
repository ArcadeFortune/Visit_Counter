package com.arcadefortune.visit_counter.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Viewers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viewer {
    @Id
    private long id; // the position in which the viewer has entered its IP address
    private String ip;
    private LocalDateTime date;
    private int viewCount;
    private int totalViewCount;

    public Viewer(String ip) {
        this.ip = ip;
        this.date = LocalDateTime.now();
        this.viewCount = 1;
    }
}
