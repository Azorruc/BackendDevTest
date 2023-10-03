package com.inditex.applicaation.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.inditex.application.controller.ProductMockApiController;
import com.inditex.application.domain.ProductMockApiDelegate;
import com.inditex.builder.ProductDetailBuilder;
import com.inditex.domain.model.product.ProductDetail;

@ExtendWith(MockitoExtension.class)
class ProductMockApiControllerTest {
	
	@InjectMocks
	private ProductMockApiController controller;
	
	@Mock
	private ProductMockApiDelegate delegate;
	
	@BeforeEach
	public void setUp() {
		this.controller = new ProductMockApiController(delegate);
	}

	@Test
	void when_get_similar_delegate_is_called() {
		this.controller.getProductSimilar("1");
		verify(this.delegate).getProductSimilar("1");
	}
	
	@Test
	void when_get_similar_data_is_retrieved() {
		
		Set<String> mockedSet = new HashSet<String>();
		mockedSet.add("1");
		mockedSet.add("2");
		mockedSet.add("3");
		
		doReturn(ResponseEntity.ok(mockedSet)).when(this.delegate).getProductSimilar(any());
		
		 ResponseEntity<Set<String>> response= this.controller.getProductSimilar("1");
		 
		 assertEquals(HttpStatus.OK, response.getStatusCode());
		 assertTrue(response.getBody().contains("1"));
		 assertTrue(response.getBody().contains("2"));
		 assertTrue(response.getBody().contains("3"));
	
	}
	
	@Test
	void when_get_detail_delegate_is_called() {
		this.controller.getProductDetail("1");
		verify(this.delegate).getProductDetail("1");
	}
	
	@Test
	void when_get_detail_data_is_retrieved() {
		doReturn(ResponseEntity.ok(new ProductDetailBuilder().build(3))).when(this.delegate).getProductDetail(any());
		
		ResponseEntity<ProductDetail> response = this.controller.getProductDetail("3");
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(new ProductDetailBuilder().build(3), response.getBody());
		
	}

}
