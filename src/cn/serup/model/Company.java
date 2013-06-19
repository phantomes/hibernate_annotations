package cn.serup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Company {
	
	private int id ;
	
	private String compayName ;
	
	private Organization org ;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompayName() {
		return compayName;
	}

	public void setCompayName(String compayName) {
		this.compayName = compayName;
	}
	
	@ManyToOne(targetEntity=Organization.class)
	@JoinColumn(name="orgid")
	//多对一注解@ManyToOne
	//targetEntity指定了关联对象
	//@JoinColumn(name="orgid")指定生产的外键的字段名，默认是org_id
	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}


}

