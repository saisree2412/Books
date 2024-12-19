package com.Books.demo.repository;

import com.Books.demo.DTO.BookRatingDTO;
import com.Books.demo.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findByBookBookId(Integer bookId);

    @Query("SELECT new com.Books.demo.DTO.BookRatingDTO(r.book.bookId, " +
            "r.book.bookName, r.book.price, r.book.genre, AVG(r.rating) as avgRating, COUNT(r) as reviewCount) " +
            "FROM Reviews r " +
            "GROUP BY r.book.bookId, r.book.bookName, r.book.price, r.book.genre " +
            "ORDER BY avgRating DESC")
    List<BookRatingDTO> findTopRated();
}
