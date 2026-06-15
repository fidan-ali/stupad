package org.example.stupad.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StudySessionDto {
    private Long id;
    private Long groupId;
    private String topic;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
