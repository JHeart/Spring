package testHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity//mapping정보를 넣어주면 table을 database에 생성하기 위한
/*@Table(name="product")//클래스이름이랑 다르게 저장하고 싶을떄 */

//entitiy annotaion을 통해서 이 객체를 entitiy bean으로 등록을 해준다.
public class Product {
	
	@Id//database에서 table의 primary key
	@GeneratedValue//key값은 자동으로 생성
	@Column(name="product_id")
	private int id;
	
	private String name;
	private int price;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="category_id")//joginkey->foregin key
	private Category category;
	
}
