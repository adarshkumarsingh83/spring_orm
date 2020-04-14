package com.adarsh.spring.repository;

import com.adarsh.spring.entity.impl.UserGroup;

import java.util.List;

/**
 * Created by Adarsh on 7/10/15.
 */
public interface UserGroupRepository {

    public UserGroup saveUserGroup(final UserGroup userGroup);

    public UserGroup updateUserGroup(final UserGroup userGroup);

    public UserGroup findUserGroupById(final Long userGroupId);

    public boolean deleteUserGroup(final UserGroup userGroup);

    public List<UserGroup> findUserGroupByUserId(final Long userId);

    public List<UserGroup> findUserGroupByGroupId(final Long groupId);

    public UserGroup findUserGroupByGroupIdAndUserId(final Long groupId,final Long userId);

    public UserGroup findUserGroupByGroupNameAndUserName(final String groupName,final String userName);

}
