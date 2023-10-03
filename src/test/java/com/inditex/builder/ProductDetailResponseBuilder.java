package com.inditex.builder;

import java.math.BigDecimal;

import com.inditex.application.controller.response.ProductDetailResponse;

public class ProductDetailResponseBuilder extends Builder<ProductDetailResponse>{

	@Override
	public ProductDetailResponse build(int index) {
		
		return new ProductDetailResponse("index::" + String.valueOf(index), 
				"::name-" + index + "::", new BigDecimal(index), true);
	}

}
