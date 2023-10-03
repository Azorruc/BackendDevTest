package com.inditex.application.domain.use_case.get_similar;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.inditex.domain.model.product.ProductDetail;

public class ProductGetSimilarUseCase {
	
	@Value("${openapi.similarProducts.mock-url}")
    private String urlGetSimilar;


    @Value("${openapi.similarProducts.mock-path}")
    private String path;
	
    private RestTemplate restTemplate = new RestTemplate();
    
	public ProductGetSimilarUseCase(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Set<ProductDetail> getSimilar(String productId){
		ResponseEntity<Set<String>> ids = restTemplate.exchange(
                path.concat(productId).concat(urlGetSimilar),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
		Set<ProductDetail> response = new HashSet<ProductDetail>();
		if(!ids.getBody().isEmpty()) {
			for(String id : ids.getBody()) {
				ResponseEntity<ProductDetail> detail = restTemplate.exchange(
						path.concat(id),
		                HttpMethod.GET,
		                null,
		                new ParameterizedTypeReference<>() {
		                }
				);
				if(detail.getBody() != null) {
					response.add(detail.getBody());
				}
			};
		}
		return response;
	}

}
