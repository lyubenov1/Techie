package com.techie.repository;

import com.techie.domain.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.parent IS NULL")
    List<Category> findAllByParentIsNull();

    @Query("SELECT c FROM Category c WHERE c.parent.id = :parentId")
    List<Category> findChildrenByParentId(@Param("parentId") Long parentId);

    Optional<Category> findByName(String categoryName);

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.parent WHERE c.name = :categoryName")
    Optional<Category> findByNameWithParent(@Param("categoryName") String categoryName);
}
