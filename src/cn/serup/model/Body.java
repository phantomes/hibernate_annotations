package cn.serup.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Body {
	
	private int id ;
	
	private String bodyName ;
	
	private Heart heart ;

	public String getBodyName() {
		return bodyName;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bodyid",unique=true)
	//一对一外键关联，使用@OneToOne，并设置了级联操作
	//@JoinColum设置了外键的名称为bodyid，即生产一个外键字段，bodyid；如果不设置，则默认为heart_id.
	//外键的值是唯一的(unique)，不可重复，与Heart的主键一直
	public Heart getHeart() {
		return heart;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setBodyName(String bodyName) {
		this.bodyName = bodyName;
	}
	
	public void setHeart(Heart heart) {
		this.heart = heart;
	}

	public void setId(int id) {
		this.id = id;
	}
}

