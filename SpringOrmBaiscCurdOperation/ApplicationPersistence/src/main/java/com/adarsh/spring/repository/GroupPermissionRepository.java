package com.adarsh.spring.repository;

import com.adarsh.spring.entity.impl.Employee;
import com.adarsh.spring.entity.impl.GroupPermission;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */

public interface GroupPermissionRepository {

    public GroupPermission saveGroupPermission(final GroupPermission groupPermission);

    public GroupPermission updateGroupPermission(final GroupPermission groupPermission);

    public GroupPermission findGroupPermissionById(final Long groupPermissionId);

    public boolean deleteGroupPermission(final GroupPermission groupPermission);

    public List<GroupPermission> findGroupPermissionByGroupId(final Long groupId);

    public List<GroupPermission> findGroupPermissionByPermissionId(final Long permissionId);

    public GroupPermission findGroupPermissionByPermissionIdAndGroupId(final Long permissionId, final Long groupId);

    public GroupPermission findGroupPermissionByPermissionNameAndGroupName(final String permissionName, final String groupName);


}
