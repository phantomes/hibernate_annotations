package cn.serup.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Heart2 {
	
	private int id ;
	
	private String heartName ;
	
	private Body body ;

	@OneToOne(mappedBy="heart",cascade=CascadeType.ALL)
	//一对一双向关联关系，使用@OneToOne
	//注意：需要加上mappedBy="heart"，如果不加上的话，
	//Heart也会生成一个外键（body_id）
	//mapped="heart"需要指向与他关联对象的一个属性
	//说明双向关联关系中，有且仅有一端是作为主体(owner)端存在的
	//主体端负责维护联接列
	//对于不需要维护这种关系的从表则通过mappedBy属性进行声明
	//mappedBy的值指向主体的关联属性
	//规律：只有是双向关联关系，都加上mapped
    //cascade=CascadeType.ALL级联
	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

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

