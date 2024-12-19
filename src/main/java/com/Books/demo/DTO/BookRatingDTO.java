package com.Books.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRatingDTO {
    private Integer bookId;
    private String bookName;
    private Double price;
    private String genre;
    private Double averageRating;
    private Long reviewCount;
}