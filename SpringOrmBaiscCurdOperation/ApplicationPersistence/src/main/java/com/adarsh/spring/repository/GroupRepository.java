package com.adarsh.spring.repository;

import com.adarsh.spring.entity.impl.Employee;
import com.adarsh.spring.entity.impl.Group;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */

public interface GroupRepository {

    public Group saveGroup(final Group group);

    public Group updateGroup(final Group group);

    public Group findGroupById(final Long groupId);

    public boolean deleteGroup(final Group group);

    public Group findGroupByName(final String groupName);

    public List<Group> getAllGroup(final boolean active);
}
