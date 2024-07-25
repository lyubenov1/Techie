package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import java.util.*;

public interface ReviewVoteRepository extends JpaRepository<ReviewVote, Long> {

    @Query("SELECT v FROM ReviewVote v " +
            "JOIN FETCH v.user u " +
            "JOIN FETCH v.review r " +
            "WHERE u = :user AND r = :review")
    Optional<ReviewVote> findByUserAndReview(@Param("user") UserEntity user, @Param("review") Review review);
}
