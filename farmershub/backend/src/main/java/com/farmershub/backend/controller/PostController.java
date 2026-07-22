package com.farmershub.backend.controller;

import com.farmershub.backend.dto.request.BuyRequest;
import com.farmershub.backend.model.Post;
import com.farmershub.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping  // POST /api/posts
    public ResponseEntity<Post> create(
            @RequestParam("userId") Long userId,
            @RequestParam("image") MultipartFile image,
            @RequestParam(value = "caption", required = false) String caption,
            @RequestParam("price") BigDecimal price,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("unit") String unit,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "location", required = false) String location
    ) throws IOException {
        return ResponseEntity.ok(
                postService.createPost(userId, image, caption, price, quantity, unit, category, location));
    }

    @GetMapping("/user/{userId}")  // GET /api/posts/user/5
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable Long userId) {
        return ResponseEntity.ok(postService.getUserPosts(userId));
    }

    @GetMapping("/feed")
    public ResponseEntity<Page<Post>> getFeed(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String category
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        if (category != null && !category.isBlank()) {
            return ResponseEntity.ok(postService.getFeedByCategory(category, pageable));
        }
        return ResponseEntity.ok(postService.getFeed(pageable));
    }

    @PostMapping("/buy")
    public ResponseEntity<Post> buy(@RequestBody BuyRequest request) {
        return ResponseEntity.ok(postService.buyPost(request.getPostId(), request.getQuantity()));
    }
}
