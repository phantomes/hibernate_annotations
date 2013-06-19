package cn.serup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Heart {
	
	private int id ;
	
	private String heartName ;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeartName() {
		return heartName;
	}

	public void setHeartName(String heartName) {
		this.heartName = heartName;
	}

}

