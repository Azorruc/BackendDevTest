package com.inditex.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.inditex.application.controller.response.ProductDetailResponse;
import com.inditex.application.controller.response.ProductDetailResponseMapper;
import com.inditex.application.domain.use_case.get_similar.ProductGetSimilarUseCase;
import com.inditex.domain.model.product.ProductDetail;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-27T18:29:06.333941+02:00[Europe/Madrid]")
@Controller
@RequestMapping("${openapi.similarProducts.base-path}")
public class ProductApiController implements ProductApi {
	
	@Autowired
	private ProductGetSimilarUseCase useCase;
	
	@Autowired
	private ProductDetailResponseMapper productDetailResponseMapper;

	public ProductApiController(ProductGetSimilarUseCase useCase, ProductDetailResponseMapper mapper) {
		this.useCase = useCase;
		this.productDetailResponseMapper = mapper;
	}

	@Override
	public ResponseEntity<Set<ProductDetailResponse>> getProductSimilar(String productId) {
		
		Set<ProductDetail> details = useCase.getSimilar(productId);
		Set<ProductDetailResponse> response= new HashSet<ProductDetailResponse>();
		for(ProductDetail detail : details) {
			response.add(productDetailResponseMapper.map(detail));
		}
		return ResponseEntity.ok(response);
	}

}
