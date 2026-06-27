package org.example.stupad.mapper;

import org.example.stupad.dao.entity.StudySession;
import org.example.stupad.model.StudySessionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudySessionMapper {
    @Mapping(source = "group.id", target = "groupId")
    StudySessionDto toStudySessionDto(StudySession studySession);

    @Mapping(source = "groupId", target = "group.id")
    StudySession toStudySession(StudySessionDto studySessionDto);

    List<StudySessionDto> toStudySessionDtoList(List<StudySession> sessions);
}
