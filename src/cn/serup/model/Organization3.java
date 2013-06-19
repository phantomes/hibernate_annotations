package cn.serup.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;


@Entity
public class Organization3 {
	
	private int id ;
	
	private String orgName ;
	
	private Set<Company3> Company3 ;


	@OneToMany(mappedBy="org")
	@JoinColumn(name="orgid")
	/**
	 * 一对多双向，在一的一端中设置mappedBy
	 * 说明多的一端为主导
	 * 如果指定了外键字段名称，则多的一端也需要指定相同的字段名称
	 */
	public Set<Company3> getCompany3() {
		return Company3;
	}

	public void setCompany3(Set<Company3> Company3) {
		this.Company3 = Company3;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}

