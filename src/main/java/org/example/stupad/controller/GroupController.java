package org.example.stupad.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.stupad.model.GroupDto;
import org.example.stupad.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupController {
    GroupService groupService;

    @GetMapping
    public List<GroupDto> getAll() {
        return groupService.getAll();
    }

    @GetMapping("/{id}")
    public GroupDto getById(@PathVariable Long id) {
        return groupService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDto create(@RequestBody GroupDto groupDto) {
        return groupService.create(groupDto);
    }
}
