package com.inditex.application.controller.response;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Generated;

/**
 * Product detail
 */

@Schema(name = "ProductDetail", description = "Product detail")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-27T18:29:06.333941+02:00[Europe/Madrid]")
@Data
@AllArgsConstructor
public class ProductDetailResponse {

  @JsonProperty("id")
  @NotNull @Size(min = 1) 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  private String id;

  @JsonProperty("name")
  @NotNull @Size(min = 1) 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  private String name;

  @JsonProperty("price")
  @NotNull @Valid 
  @Schema(name = "price", requiredMode = Schema.RequiredMode.REQUIRED)
  private BigDecimal price;

  @JsonProperty("availability")
  @NotNull 
  @Schema(name = "availability", requiredMode = Schema.RequiredMode.REQUIRED)
  private Boolean availability;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDetailResponse productDetail = (ProductDetailResponse) o;
    return Objects.equals(this.id, productDetail.id) &&
        Objects.equals(this.name, productDetail.name) &&
        Objects.equals(this.price, productDetail.price) &&
        Objects.equals(this.availability, productDetail.availability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price, availability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDetail {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

