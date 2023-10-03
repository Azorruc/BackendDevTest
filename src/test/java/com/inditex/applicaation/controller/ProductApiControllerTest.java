package com.inditex.applicaation.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.inditex.application.controller.ProductApiController;
import com.inditex.application.controller.response.ProductDetailResponse;
import com.inditex.application.controller.response.ProductDetailResponseMapper;
import com.inditex.application.domain.use_case.get_similar.ProductGetSimilarUseCase;
import com.inditex.builder.ProductDetailBuilder;
import com.inditex.builder.ProductDetailResponseBuilder;
import com.inditex.domain.model.product.ProductDetail;

@ExtendWith(MockitoExtension.class)
class ProductApiControllerTest {
	
	@InjectMocks
	private ProductApiController controller;
	
	@Mock
	private ProductGetSimilarUseCase useCase;
	
	@Mock
	private ProductDetailResponseMapper mapper;
	
	@BeforeEach
	void setup() {
		this.controller = new ProductApiController(useCase, mapper);
	}

	@Test
	void when_get_similars_use_case_is_used() {
		this.controller.getProductSimilar("1");
		verify(this.useCase).getSimilar("1");
	}
	
	@Test
	void when_use_case_is_used_data_is_mapped() {
		
		Set<ProductDetail> mockedSet = new HashSet<ProductDetail>();
		mockedSet.add(new ProductDetailBuilder().build(1));
		mockedSet.add(new ProductDetailBuilder().build(2));
		mockedSet.add(new ProductDetailBuilder().build(3));
		
		doReturn(mockedSet).when(this.useCase).getSimilar(any());
		this.controller.getProductSimilar("1");
		verify(this.mapper).map(new ProductDetailBuilder().build(1));
		verify(this.mapper).map(new ProductDetailBuilder().build(2));
		verify(this.mapper).map(new ProductDetailBuilder().build(3));
	}
	
	@Test
	void when_use_case_and_mapper_are_used_data_is_retrieved() {
		
		Set<ProductDetail> mockedSet = new HashSet<ProductDetail>();
		mockedSet.add(new ProductDetailBuilder().build(1));
		mockedSet.add(new ProductDetailBuilder().build(2));
		mockedSet.add(new ProductDetailBuilder().build(3));
		
		doReturn(mockedSet).when(this.useCase).getSimilar(any());
		doReturn(new ProductDetailResponseBuilder().build(2)).when(this.mapper).map(any());
		
		ResponseEntity<Set<ProductDetailResponse>> response = this.controller.getProductSimilar("1");
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().contains(new ProductDetailResponseBuilder().build(2)));
		
	}
	

}
