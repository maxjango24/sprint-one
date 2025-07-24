package com.yanhol;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Task {

    private int id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return "ID: %d | %s | %s | %s | %b ".formatted(id, title, description, formatter.format(deadline), done);
    }
}
