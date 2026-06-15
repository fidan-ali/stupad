package org.example.stupad.mapper;

import org.example.stupad.dao.entity.Group;
import org.example.stupad.model.GroupDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GroupMemberMapper.class, StudySessionMapper.class})
public interface GroupMapper {
    GroupDto toDto(Group group);
    Group toEntity(GroupDto groupDto);
}
