package com.javaetmoi.benchmark.mapping.mapper.bull;

import com.expediagroup.beans.BeanUtils;
import com.expediagroup.beans.transformer.BeanTransformer;
import com.expediagroup.transformer.model.FieldMapping;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

/**
 * BULL mapper.
 * For more details see: https://github.com/ExpediaGroup/bull.
 */
public class BullMapper implements OrderMapper {
  private final BeanTransformer transformer;

  public BullMapper() {
    FieldMapping<String, String> customerNameMapping = new FieldMapping<>(
      "customer.name",
      "customerName"
    );
    FieldMapping<String, String> billingAddressCityMapping = new FieldMapping<>(
      "customer.billingAddress.city",
      "billingCity"
    );
    FieldMapping<String, String> billingAddressStreetMapping = new FieldMapping<>(
      "customer.billingAddress.street",
      "billingStreetAddress"
    );
    FieldMapping<String, String> shippingAddressCityMapping = new FieldMapping<>(
      "customer.shippingAddress.city",
      "shippingCity"
    );
    FieldMapping<String, String> shippingAddressStreetMapping = new FieldMapping<>(
      "customer.shippingAddress.street",
      "shippingStreetAddress"
    );

    this.transformer = new BeanUtils().getTransformer().withFieldMapping(
      customerNameMapping,
      billingAddressCityMapping,
      billingAddressStreetMapping,
      shippingAddressCityMapping,
      shippingAddressStreetMapping
    );
  }

  @Override
  public OrderDTO map(Order source) {
    return transformer.transform(source, OrderDTO.class);
  }
}