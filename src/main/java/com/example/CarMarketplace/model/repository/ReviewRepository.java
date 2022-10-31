package com.example.CarMarketplace.model.repository;

import com.example.CarMarketplace.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository <Review, Integer>{

    @Query(value = "select * from Review_E r " +
            "where lower(r.id) like lower(concat('%', :postId, '%'))", nativeQuery = true)
    List<Review> searchReview(@Param("postId") String postId);
}
