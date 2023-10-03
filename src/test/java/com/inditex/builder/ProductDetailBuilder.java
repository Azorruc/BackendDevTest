package com.inditex.builder;

import java.math.BigDecimal;

import com.inditex.domain.model.product.ProductDetail;

public class ProductDetailBuilder extends Builder<ProductDetail>{

	@Override
	public ProductDetail build(int index) {
		
		return new ProductDetail("index::" + String.valueOf(index), 
				"::name-" + index + "::", new BigDecimal(index), true);
	}

}
