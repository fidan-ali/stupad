package org.example.stupad.mapper;

import org.example.stupad.dao.entity.GroupMember;
import org.example.stupad.model.GroupMemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMemberMapper {
    @Mapping(source = "group.id", target = "groupId")
    @Mapping(source = "user.id", target = "userId")
    GroupMemberDto toGroupMemberDto(GroupMember groupMember);

    @Mapping(source = "groupId", target = "group.id")
    @Mapping(source = "userId", target = "user.id")
    GroupMember toGroup(GroupMemberDto groupMemberDto);

    List<GroupMemberDto> toGroupMemberDtoList(List<GroupMember> members);
}
