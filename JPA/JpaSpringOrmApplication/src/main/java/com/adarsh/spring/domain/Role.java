package com.adarsh.spring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="role")
public class Role {

    public Role() {
    }

    public Role(Long id, Integer role, User user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }

    @Id
	private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
	
	@OneToOne
	private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

	private Integer role;

	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role=" + role +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
