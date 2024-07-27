package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {
    List<Blacklist> findByUserIdIn(List<Long> userIds);
}