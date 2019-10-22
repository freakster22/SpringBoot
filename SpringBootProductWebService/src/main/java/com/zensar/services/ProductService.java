package com.zensar.services;

import java.util.List;

import com.zensar.entities.Product;

/**
 * @author Arib aka FREAKSTER
 * @creation_date 4th Oct 2019 11:39
 * @creation_date 12th Oct 2019 17:39
 * @version 5.0
 * @copyright Zensar Tech
 * @description It is Product Service Class This is used in Business Layer.
 *
 */
public interface ProductService {
	List<Product> findAllProducts();

	Product findById(int productId);

	void updateProduct(Product product);

	void addProduct(Product product);

	void removeProduct(Product product);

	// Anyother Business Logic
	// Examples:
	List<Product> findProductsByPriceRance(float min, float max);

	List<Product> findProductsByName(String name);

	List<Product> findProductsByBrand(String brand);

	long getProductCount();// returns count of products in table.
}
