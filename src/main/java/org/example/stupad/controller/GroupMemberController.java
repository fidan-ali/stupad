package org.example.stupad.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.stupad.model.GroupMemberDto;
import org.example.stupad.service.GroupMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupMemberController {
    GroupMemberService groupMemberService;

    @GetMapping
    public List<GroupMemberDto> getAll() {
        return groupMemberService.getAll();
    }

    @GetMapping("/groups/{groupId}/users/{userId}")
    public GroupMemberDto getById(@PathVariable Long groupId, @PathVariable Long userId) {
        return groupMemberService.getById(groupId, userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroupMemberDto add(@RequestBody GroupMemberDto groupMemberDto) {
        return groupMemberService.add(groupMemberDto);
    }
}
