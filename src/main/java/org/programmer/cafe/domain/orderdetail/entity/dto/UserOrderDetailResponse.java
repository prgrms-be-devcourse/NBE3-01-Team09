package org.programmer.cafe.domain.orderdetail.entity.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserOrderDetailResponse {
    private Long id;
    private int count;
    private int totalPrice;
    private Long itemId;
    private String itemName;
    private String itemImage;
    private String address;
    private String address_detail;
    private String zipcode;
    private Long orderId;
}
