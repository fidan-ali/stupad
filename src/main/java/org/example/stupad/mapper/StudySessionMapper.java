package org.example.stupad.mapper;

import org.example.stupad.dao.entity.StudySession;
import org.example.stupad.model.StudySessionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface StudySessionMapper {
    @Mapping(source = "group.id", target = "groupId")
    StudySessionDto toDto(StudySession studySession);

    @Mapping(source = "groupId", target = "group.id")
    StudySession toEntity(StudySessionDto studySessionDto);
}
