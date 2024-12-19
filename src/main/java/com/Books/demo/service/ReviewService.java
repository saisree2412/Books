package com.Books.demo.service;

import com.Books.demo.DTO.BookRatingDTO;
import com.Books.demo.model.Reviews;
import com.Books.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    public List<Reviews> allReviews() {
        return reviewRepository.findAll();
    }
    public List<Reviews> getReviewsByBookId(Integer bookId) {
        return reviewRepository.findByBookBookId(bookId);
    }

    public List<BookRatingDTO> getTopRatedBooks() {
        return reviewRepository.findTopRated();

    }
}
