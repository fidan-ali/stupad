package org.example.stupad.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.stupad.dao.entity.StudySession;
import org.example.stupad.dao.repository.StudySessionRepository;
import org.example.stupad.exception.ResourceNotFoundException;
import org.example.stupad.mapper.StudySessionMapper;
import org.example.stupad.model.StudySessionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudySessionService {
    StudySessionRepository studySessionRepository;
    StudySessionMapper studySessionMapper;

    public List<StudySessionDto> getAll() {
        List<StudySession> sessions = studySessionRepository.findAll();
        return studySessionMapper.toStudySessionDtoList(sessions);
    }

    public StudySessionDto getById(Long id) {
        StudySession session = studySessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Session not found with id: " + id));
        return studySessionMapper.toStudySessionDto(session);
    }

    public StudySessionDto create(StudySessionDto studySessionDto) {
        StudySession session = studySessionMapper.toStudySession(studySessionDto);
        StudySession savedSession = studySessionRepository.save(session);
        return studySessionMapper.toStudySessionDto(savedSession);
    }
}
