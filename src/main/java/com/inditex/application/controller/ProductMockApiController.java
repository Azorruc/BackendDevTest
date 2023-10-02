package com.inditex.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.inditex.application.domain.ProductMockApiDelegate;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-27T18:29:06.333941+02:00[Europe/Madrid]")
@Controller
@RequestMapping("${openapi.similarProducts.base-path:}")
public class ProductMockApiController implements ProductMockApi {

    private final ProductMockApiDelegate delegate;

    public ProductMockApiController(@Autowired(required = false) ProductMockApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ProductMockApiDelegate() {});
    }

    @Override
    public ProductMockApiDelegate getDelegate() {
        return delegate;
    }

}
