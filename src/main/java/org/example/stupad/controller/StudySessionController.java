package org.example.stupad.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.stupad.model.StudySessionDto;
import org.example.stupad.service.StudySessionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudySessionController {
    StudySessionService studySessionService;

    @GetMapping
    public List<StudySessionDto> getAll() {
        return studySessionService.getAll();
    }

    @GetMapping("/{id}")
    public StudySessionDto getById(@PathVariable Long id) {
        return studySessionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudySessionDto create(@RequestBody StudySessionDto studySessionDto) {
        return studySessionService.create(studySessionDto);
    }
}
