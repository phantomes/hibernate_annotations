package cn.serup.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Organization2 {
	
	private int id ;
	
	private String orgName ;
	
	private Set<Company> company2 ;

	@OneToMany
	@JoinColumn(name="orgid")
	/**
	 * 一对多注解@OneToMany（单向）
	 * 如果只写@OneToMany的话，hibernate会建一张中间表来
	 * 维护他们之间的关系，
	 * 加上@JoinColumn(name="orgid")，则不会建中间表，他会在
	 * 多的一端加上外键orgid，来维护他们之间的关系
	 */
	public Set<Company> getCompany2() {
		return company2;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setCompany2(Set<Company> company) {
		this.company2 = company;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}

