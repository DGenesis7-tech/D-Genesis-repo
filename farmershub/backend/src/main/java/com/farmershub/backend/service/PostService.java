package com.farmershub.backend.service;

import com.farmershub.backend.model.Post;
import com.farmershub.backend.model.User;
import com.farmershub.backend.repository.PostRepository;
import com.farmershub.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private static final String UPLOAD_DIR = "uploads/posts/";

    public Post createPost(Long userId, MultipartFile image, String caption, BigDecimal price, Integer quantity, String unit, String category, String location) throws IOException {
        User user = userRepository.findById(userId).orElseThrow();

        String filename = userId + "_" + System.currentTimeMillis() + "_" + image.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + filename);
        Files.createDirectories(path.getParent());
        Files.write(path, image.getBytes());

        boolean isAvailable = quantity != null && quantity > 0;

        Post post = Post.builder()
                .user(user)
                .imageUrl("/uploads/posts/" + filename)
                .caption(caption)
                .price(price)
                .quantity(quantity)
                .unit(unit)
                .category(category)
                .location(location)
                .available(isAvailable)
                .build();

        return postRepository.save(post);
    }

    public Post buyPost(Long postId, Integer requestedQuantity) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

        if (requestedQuantity == null || requestedQuantity <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantity must be greater than zero");
        }

        if (!post.isAvailable() || post.getQuantity() == null || post.getQuantity() < requestedQuantity) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient quantity available");
        }

        post.setQuantity(post.getQuantity() - requestedQuantity);
        if (post.getQuantity() <= 0) {
            post.setQuantity(0);
            post.setAvailable(false);
        }

        return postRepository.save(post);
    }

    public List<Post> getUserPosts(Long userId) {
        return postRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public org.springframework.data.domain.Page<Post> getFeed(org.springframework.data.domain.Pageable pageable) {
        return postRepository.findByAvailableTrue(pageable);
    }

    public org.springframework.data.domain.Page<Post> getFeedByCategory(String category, org.springframework.data.domain.Pageable pageable) {
        return postRepository.findByCategoryAndAvailableTrue(category, pageable);
    }
}