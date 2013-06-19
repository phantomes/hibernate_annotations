package cn.serup.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role2 {
	
	private int id ;
	
	private String roleName ;
	
	private Set<User2> user = new HashSet<User2>() ;

	@ManyToMany(mappedBy="role")
	/**
	 * 多对多,双向关联映射 
	 */
	public Set<User2> getUser() {
		return user;
	}

	public void setUser(Set<User2> user) {
		this.user = user;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}

