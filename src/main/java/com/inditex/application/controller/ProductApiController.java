package com.inditex.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.inditex.application.controller.response.ProductDetailResponse;
import com.inditex.application.domain.ProductMockApiDelegate;

import java.util.Optional;
import java.util.Set;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-27T18:29:06.333941+02:00[Europe/Madrid]")
@Controller
@RequestMapping("${openapi.similarProducts.base-path:}")
public class ProductApiController implements ProductApi {

	@Override
	public ResponseEntity<Set<ProductDetailResponse>> getProductSimilar(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
