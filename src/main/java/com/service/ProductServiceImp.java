package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDAO;
import com.entity.PurchaseOrder;
import com.entity.Product;

/**
 * 
 * @author Tomasz Gomoradzki
 * Application Service layer for Product object interface implementation
 *
 */

@Service  // We add the annotation to service implementation
public class ProductServiceImp implements ProductService {
	
	// Injection of the Client DAO
	@Autowired
	private ProductDAO ProductDAO;
		
	@Override
	@Transactional // Service layer define the beginning and end of transaction
	public List<Product> getProducts() {
		// Delegating the get request to DAO
		return ProductDAO.getProducts();
	}


	@Override
	@Transactional
	public void saveProduct(Product thePorder) {
		ProductDAO.saveProduct(thePorder);		
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
