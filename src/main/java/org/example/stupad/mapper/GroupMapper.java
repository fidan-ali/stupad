package org.example.stupad.mapper;

import org.example.stupad.dao.entity.Group;
import org.example.stupad.dao.entity.User;
import org.example.stupad.model.GroupDto;
import org.example.stupad.model.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GroupMemberMapper.class, StudySessionMapper.class})
public interface GroupMapper {
    GroupDto toGroupDto(Group group);
    Group toGroup(GroupDto groupDto);
    List<GroupDto> toGroupDtoList(List<Group> groups);
}
