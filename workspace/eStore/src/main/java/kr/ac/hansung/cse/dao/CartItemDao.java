package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Cart;
import kr.ac.hansung.cse.model.CartItem;

@Repository
@Transactional
public class CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCartItem(CartItem cartItem){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}
	
	public void removeCartItem(CartItem cartItem){
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}
	
	public void removeAllCartItems(Cart cart){
		List<CartItem> cartItems = cart.getCartItems();  // cart를 읽을때 fetch 가 EAGER 라서 이미 카트 안에는 cartitems 가 있다 즉, 지금 eager니까 값이 나오는거지
		for(CartItem item : cartItems){                  // lazy 라면 여기서 Null 이 나올 것 이다. 즉 lazy라면 읽는 부분이 추가 되어야 한다.  
			removeCartItem(item);
		}
	}
	
	public CartItem getCartItemByProductId(int cartId, int productId){
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<CartItem> query = session.createQuery("from CartItem where cart.id=? and product.id=?");
		query.setParameter(0,cartId);
		query.setParameter(1,productId);
		
		return (CartItem) query.getSingleResult();
	}

	public void minusCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}
}
