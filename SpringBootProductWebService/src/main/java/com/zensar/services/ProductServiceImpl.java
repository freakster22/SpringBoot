package com.zensar.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.daos.ProductDao;
import com.zensar.entities.Product;

/**
 * @author Arib aka FREAKSTER
 * @creation_date 4th Oct 2019 11:39
 * @modification_date 12th Oct 2019 15:39
 * @version 5.0
 * @copyright Zensar Tech
 * @description It is Product Service Class This is used in Business Layer.
 *				Creating ProductDao Object by Spring and injecting in ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findAllProducts() {

		return productDao.getAllProduct();
	}

	@Override
	public Product findById(int productId) {

		return productDao.getById(productId);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.update(product);

	}

	@Override
	public void addProduct(Product product) {
		productDao.insert(product);

	}

	@Override
	public void removeProduct(Product product) {
		productDao.delete(product);

	}

	@Override
	public List<Product> findProductsByPriceRance(float min, float max) {
		List<Product> myList = new ArrayList<>();
		List<Product> allProducts = productDao.getAllProduct();
		for (Product i : allProducts) {
			if (i.getPrice() >= min && i.getPrice() <= max)
				myList.add(i);
		}
		return myList;
	}

	@Override
	public List<Product> findProductsByName(String name) {
		List<Product> myList = new ArrayList<>();
		List<Product> allProducts = productDao.getAllProduct();

		for (Product i : allProducts) {
			if (i.getName().equalsIgnoreCase(name))
				myList.add(i);
		}
		return myList;
	}

	@Override
	public List<Product> findProductsByBrand(String brand) {
		List<Product> myList = new ArrayList<>();
		List<Product> allProducts = productDao.getAllProduct();
		for (Product i : allProducts) {
			if (i.getBrand().equalsIgnoreCase(brand))
				myList.add(i);
		}
		return myList;
	}

	@Override
	public long getProductCount() {
		int count = 0;
		List<Product> allProducts = productDao.getAllProduct();
		for (Product i : allProducts) {
			count++;
		}
		return count;
	}

}
