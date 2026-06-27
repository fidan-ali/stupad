package org.example.stupad.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.stupad.dao.entity.GroupMember;
import org.example.stupad.dao.repository.GroupMemberRepository;
import org.example.stupad.exception.ResourceNotFoundException;
import org.example.stupad.mapper.GroupMemberMapper;
import org.example.stupad.model.GroupMemberDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupMemberService {
    GroupMemberRepository groupMemberRepository;
    GroupMemberMapper groupMemberMapper;

    public List<GroupMemberDto> getAll() {
        List<GroupMember> members = groupMemberRepository.findAll();
        return groupMemberMapper.toGroupMemberDtoList(members);
    }

    public GroupMemberDto getById(Long groupId, Long userId) {
        GroupMember.GroupMemberId id = new GroupMember.GroupMemberId(groupId, userId);
        GroupMember member = groupMemberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Member relationship not found for Group ID: %d and User ID: %d", groupId, userId)));
        return groupMemberMapper.toGroupMemberDto(member);
    }

    public GroupMemberDto add(GroupMemberDto groupMemberDto) {
        GroupMember member = groupMemberMapper.toGroupMember(groupMemberDto);
        log.info("Adding group member relationship: {}", member);
        GroupMember savedMember = groupMemberRepository.save(member);
        return groupMemberMapper.toGroupMemberDto(savedMember);
    }
}
