package com.inditex.application.controller.response;

import com.inditex.application.contract.Mapper;
import com.inditex.domain.model.product.*;

public class ProductDetailResponseMapper implements Mapper<ProductDetail, ProductDetailResponse>{

	@Override
	public ProductDetailResponse map(ProductDetail input) {
		return new ProductDetailResponse(input.getId(), input.getName(), input.getPrice(), input.getAvailability());
	}

}
