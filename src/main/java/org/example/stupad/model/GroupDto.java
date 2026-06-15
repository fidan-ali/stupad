package org.example.stupad.model;

import lombok.Data;

import java.util.List;
@Data
public class GroupDto {
    private Long id;
    private String name;
    private List<GroupMemberDto> members;
    private List<StudySessionDto> sessions;
}
