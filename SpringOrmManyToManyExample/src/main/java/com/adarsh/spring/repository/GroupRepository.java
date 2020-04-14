package com.adarsh.spring.repository;

import java.util.List;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:15 PM
 * This Class provide the implementation for the functionality of..
 */

public interface GroupRepository<G> {

    public void saveGroup(G group);

    public void saveGroups(List<G> list);

    public G getGroup(G group);

    public List<G> getGroup();

    public void deleteGroup(G group);
}
