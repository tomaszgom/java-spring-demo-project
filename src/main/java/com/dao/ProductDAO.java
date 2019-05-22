package com.dao;

import java.util.HashMap;
import java.util.List;
import com.entity.Product;
import com.entity.PurchaseOrder;

/**
 * 
 * @author Tomasz Gomoradzki
 * Product Data Access Object interface
 * 
 */

public interface ProductDAO {

	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int productId);

	public void deleteProduct(int productId);

	public List<Product> searchProducts(String srchName);
	
}
