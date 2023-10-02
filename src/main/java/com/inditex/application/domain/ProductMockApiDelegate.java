package com.inditex.application.domain;



import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import com.inditex.application.contract.ApiUtil;
import com.inditex.application.controller.ProductMockApi;
import com.inditex.application.controller.ProductMockApiController;
import com.inditex.domain.model.product.ProductDetail;

import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link ProductMockApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-27T18:29:06.333941+02:00[Europe/Madrid]")
public interface ProductMockApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /product/{productId}/similar : Similar products
     *
     * @param productId  (required)
     * @return OK (status code 200)
     *         or Product Not found (status code 404)
     * @see ProductMockApi#getProductSimilar
     */
    default ResponseEntity<Set<String>> getProductSimilar(String productId) {
    	return ApiUtil.getSimilarProductsMockResponse();
    }
    
    default ResponseEntity<ProductDetail> getProductDetail(String productId) {
    	return null;
    }

}
