package com.anatomica.market.services;

import com.anatomica.market.entities.OrderItem;
import com.anatomica.market.entities.dtos.OrderItemDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    public List<OrderItemDto> mapEntityListToDtoList(List<OrderItem> orderItemList) {
        return orderItemList.stream().map(OrderItemDto::new).collect(Collectors.toList());
    }
}
