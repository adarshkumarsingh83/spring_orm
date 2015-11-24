package com.adarsh.spring.repository;

import java.util.List;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:01 PM
 * This Class provide the implementation for the functionality of..
 */

public interface PermissionRepository<P>{

    public void savePermission(P permission);

    public void savePermissions(List<P> list);

    public P getPermission(P permission);

    public List<P> getPermissions();

    public void updatePermission(P permission);

    public void deletePermission(P permission);

}
