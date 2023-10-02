package com.inditex.application.contract;

import org.springframework.http.ResponseEntity;

import com.inditex.domain.model.product.ProductDetail;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ApiUtil {
	
	private static Set<String> mockedSimilarProductsIds = new HashSet<String>(Arrays.asList("1", "3", "5"));
	private static final ProductDetail mockedProductDetail = 
			new ProductDetail("id", "name", new BigDecimal(10.5), true);
	
    public static ResponseEntity<Set<String>> getSimilarProductsMockResponse() {
		return ResponseEntity.ok(mockedSimilarProductsIds);
    }
}
