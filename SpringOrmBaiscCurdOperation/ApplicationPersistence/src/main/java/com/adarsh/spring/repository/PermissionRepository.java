package com.adarsh.spring.repository;

import com.adarsh.spring.entity.impl.Employee;
import com.adarsh.spring.entity.impl.Permission;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */

public interface PermissionRepository {

    public Permission savePermission(final Permission permission);

    public Permission updatePermission(final Permission permission);

    public Permission findByPermissionId(final Long permissionId);

    public boolean deletePermission(final Permission permission);

    public Permission findByPermissionName(final String permissionName);

    public List<Permission> getAllPermission(final boolean active);
}
