package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import java.util.*;

public interface ReviewVoteRepository extends JpaRepository<ReviewVote, Long> {

    @Query("SELECT rv FROM ReviewVote rv " +
            "JOIN FETCH rv.user u " +
            "JOIN FETCH rv.review r " +
            "WHERE u = :user AND r = :review")
    Optional<ReviewVote> findByUserAndReview(@Param("user") UserEntity user, @Param("review") Review review);

    @Modifying
    @Query("DELETE FROM ReviewVote rv WHERE rv.review.id = :reviewId")
    void deleteByReviewId(@Param("reviewId") Long reviewId);
}
