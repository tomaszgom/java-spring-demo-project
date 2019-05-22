package com.service;

import java.util.List;

import com.entity.PurchaseOrder;
import com.entity.Product;

/**
 * 
 * @author Tomasz Gomoradzki
 * Application Service layer for Product object interface
 *
 */


public interface ProductService {

	public List<Product> getProducts();

	public List<PurchaseOrder> getPurchaseOrders();

	public void saveProduct(Product theProduct);

}
