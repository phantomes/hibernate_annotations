package cn.serup.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity表示该是实体类
@Entity
public class Teacher {
	
	private int id ;
	
	private String username ;
	
	private String password ;
	
	//ID为主键，主键手动分配
	@Id
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

