package org.example.stupad.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.stupad.dao.entity.Group;
import org.example.stupad.dao.repository.GroupRepository;
import org.example.stupad.exception.ResourceNotFoundException;
import org.example.stupad.mapper.GroupMapper;
import org.example.stupad.model.GroupDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupService {
    GroupRepository groupRepository;
    GroupMapper groupMapper;

    public List<GroupDto> getAll(){
        List<Group> groups = groupRepository.findAll();
        return groupMapper.toGroupDtoList(groups);
    }

    public GroupDto getById(Long id){
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id: " + id));
        return groupMapper.toGroupDto(group);
    }

    public GroupDto create(GroupDto groupDto){
        Group group = groupMapper.toGroup(groupDto);

        log.info("Saving group to database: {}", group);
        Group savedGroup = groupRepository.save(group);

        return groupMapper.toGroupDto(savedGroup);
    }
}
