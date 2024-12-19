package com.Books.demo.controller;

import com.Books.demo.model.Reviews;
import com.Books.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Books.demo.DTO.BookRatingDTO;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @GetMapping("/all")
    public ResponseEntity<List<Reviews>>getAllReviews(){
        try {
            List<Reviews> reviews = reviewService.allReviews();
            if (reviews.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<List<Reviews>> getReviewsById(@PathVariable Integer bookId){
        try{
            List<Reviews> reviews = reviewService.getReviewsByBookId(bookId);
            if (reviews.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/toprated")
    public ResponseEntity<List<BookRatingDTO>> getTopRated(){
        try{
            List<BookRatingDTO> books = reviewService.getTopRatedBooks();
            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }






}

