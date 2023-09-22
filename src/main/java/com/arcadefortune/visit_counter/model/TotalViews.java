package com.arcadefortune.visit_counter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Viewers")
@Data
@AllArgsConstructor
public class TotalViews {
    @Id
    private String id; // the position in which the viewer has entered its IP address
    private int totalViews;

    public TotalViews() {
        this.id = "0";
        this.totalViews = 0;
    }

    public void addView() {
        this.totalViews += 1;
    }
}
