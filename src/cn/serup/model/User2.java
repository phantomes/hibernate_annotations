package cn.serup.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User2 {
	
	private int id ;
	
	private String username ;
	
	private Set<Role2> role = new HashSet<Role2>() ;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@ManyToMany
	/**
	 * 多对多映射：注解@ManyToMany（单向）
	 * 默认情况下，hibernate会自动的创建一张中间表，
	 * 来维护多对多关系
	 * 默认中间表的名称 ：user_role中间表，字段的名称u_id r_id
	 * 如果想更换表名和字段名称，注解如下：
	 */
	@JoinTable(name="t_u_r",
			joinColumns={@JoinColumn(name="u_id")},
			inverseJoinColumns={@JoinColumn(name="r_id")}
	)
	/**
	 * @JoinTable(name="t_u_r",
	 * 指定中间表的表名
	 * joinColumns={@JoinColumn(name="u_id")},
	 * 指定当前对象的外键
	 * inverseJoinColumns={@JoinColumn(name="r_id")}
	 * 指定关联对象的外键
	 */
	
	public Set<Role2> getRole() {
		return role;
	}

	public void setRole(Set<Role2> role) {
		this.role = role;
	}

	
}

