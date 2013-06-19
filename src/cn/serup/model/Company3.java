package cn.serup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Company3 {
	
	private int id ;
	
	private String compayName ;
	
	private Organization3 org ;
	
	@ManyToOne
	@JoinColumn(name="orgid")
	/**
	 * 一对多双向
	 * 需要指定外键与一的一端给的外键名称一致，@JoinColumn(name="orgid")
	 * 也可以不指定，如果在多的一端不指定，则一的一端也不能指定
	 * 否则为生成两个外键
	 */
	public Organization3 getOrg() {
		return org;
	}

	public void setOrg(Organization3 org) {
		this.org = org;
	}

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


}

