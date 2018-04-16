package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity//entitiy를 넣어주어야 table로 저장이 된다. database에 넣어줄 겄이다.
public class Category {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.LAZY)//persist or delete 연관된 모든것이 적용
	private Set<Product> products = new HashSet<Product>();
	
}
