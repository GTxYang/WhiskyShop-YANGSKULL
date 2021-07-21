package WhiskyShop.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import WhiskyShop.Dto.CartDto;
import WhiskyShop.Dto.ProductsDto;

@Repository
public class CartDao extends BaseDAO {

	@Autowired
	ProductsDao productDao = new ProductsDao();

	// Ktra nếu chưa có gì hết thì sẽ tạo mới 1 giỏ hàng nếu đã có rồi mà còn tồn
	// tại key đó thì mình sẽ set
	// số lượng lên
	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productDao.FindProductByID(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setPrice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		} else {

			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			itemCart.setPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;

	}

	public HashMap<Long, CartDto> EditCart(long id, int quantity, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			double totalPrice = quantity * itemCart.getProduct().getPrice();
			itemCart.setPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int TotalQuantity(HashMap<Long, CartDto> cart) {
		int totalQuantity = 0;
		for (Map.Entry<Long, CartDto> itemcart : cart.entrySet()) {
			totalQuantity += itemcart.getValue().getQuantity();
		}
		return totalQuantity;
	}
	
	
	public double TotalPrice(HashMap<Long, CartDto> cart) {
		int totalPrice = 0;
		for (Map.Entry<Long, CartDto> itemcart : cart.entrySet()) {
			totalPrice += itemcart.getValue().getPrice();
		}
		return totalPrice;
	}

	
	/*
	 * public int TotalQuantity(HashMap<Long, CartDto> cart) { int totalQuantity =
	 * 0; for (int i = 0; i < cart.size(); i++) { totalQuantity +=
	 * cart.get(i).getQuantity(); } return totalQuantity; }
	 */

	/*
	 * public double TotalPrice(HashMap<Long, CartDto> cart) { double totalPrice =
	 * 0; for (int i = 0; i < cart.size(); i++) { totalPrice +=
	 * cart.get(i).getPrice(); } return totalPrice; }
	 */

}
