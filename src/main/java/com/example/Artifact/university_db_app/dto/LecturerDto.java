package com.example.Artifact.university_db_app.dto;

import com.example.Artifact.university_db_app.model.Lecture;

public record LecturerDto(String name, String email, String department) {

    public static LecturerDto from(Lecture l) {
        return new LecturerDto(
                l.getName(),
                l.getEmail(),
                l.getDepartment().getName()
        );
    }
}
