package com.zensar.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.entities.Product;

/**
 * @author Arib aka FREAKSTER
 * @creation_date 4th Oct 2019 10:23
 * @modificationDate 12thOct 2019 10:09
 * @version 5.0
 * @copyright Zensar Tech
 * @description It is Product Dao Class.
 * 				This uses persistent Layer.
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return (List<Product>) hibernateTemplate.find("from Product");
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Product.class, productId);
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(product);
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(product);
	}
	


}
