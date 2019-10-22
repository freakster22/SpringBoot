package com.zensar.daos;

import java.util.List;



import com.zensar.entities.Product;

/**
 * @author Arib aka FREAKSTER
 * @creation_date 4th Oct 2019 10:07
 * @modificationDate 12th Oct 2019 15:40
 * @version 5.0
 * @copyright Zensar Tech
 * @description It is Product Dao Interface
 *				This uses persistent Layer.
 *
 */
public interface ProductDao {
	List<Product> getAllProduct();
	Product getById(int productId);
	
	void insert(Product product);
	void update(Product product);
	void delete(Product product);
	
}

