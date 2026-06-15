package org.example.stupad.dao.repository;

import org.example.stupad.dao.entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, GroupMember.GroupMemberId> {
    boolean existsByIdGroupIdAndIdUserId(Long groupId, Long userId);
}
