package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDTO> fetchAndConvertCommentsToDTOs(Product product) {
        List<Comment> comments = commentRepository.findAllByProductIdWithAssociations(product.getId());
        return comments.stream().map(this::convertToCommentDTO).toList();
    }

    private CommentDTO convertToCommentDTO(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .timestamp(comment.getTimestamp())
                .user(comment.getUser().getUsername())
                .upvoteCount(comment.getUpvote())
                .downvoteCount(comment.getDownvote())
                .imageUrls(comment.getImages().stream().map(CommentImage::getImageUrl).collect(Collectors.toList()))
                .build();
    }
}
