package com.farmershub.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Which user posted this

    @Column(nullable = false)
    private String imageUrl;

    private String caption;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private BigDecimal price;          // e.g. 8500.00

    private Integer quantity;          // bags/kg/items available

    private String unit;              // "bag", "kg", "bunch", "crate"

    private String category;          // "CROPS", "LIVESTOCK", "VEGETABLES"

    private String location;          // farmer's location for display

    private boolean available = true;  // false when qty = 0

}
