package org.example.stupad.model;

import lombok.Data;

@Data
public class GroupMemberDto {
    private Long id;
    private Long groupId;
    private Long userId;
    private String role;
}
