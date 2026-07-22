package com.farmershub.backend.dto.request;

import lombok.Data;

@Data
public class BuyRequest {
    private Long postId;
    private Integer quantity;
}
