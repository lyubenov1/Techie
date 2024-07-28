package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {
    Optional<Blacklist> findByUserId(Long userId);

    @Query("SELECT b FROM Blacklist b JOIN FETCH b.user u JOIN FETCH u.roles")
    Page<Blacklist> findAllFetchUsers(Pageable pageable);
}