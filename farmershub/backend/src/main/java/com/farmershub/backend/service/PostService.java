package com.farmershub.backend.service;

import com.farmershub.backend.model.Post;
import com.farmershub.backend.model.User;
import com.farmershub.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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

        Post post = Post.builder()
                .user(user)
                .imageUrl("/uploads/posts/" + filename)
                .caption(caption)
                .price(price)
                .quantity(quantity)
                .unit(unit)
                .category(category)
                .location(location)
                .build();

        return postRepository.save(post);
    }

    public List<Post> getUserPosts(Long userId) {
        return postRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }
}