package com.Books.demo.repository;

import com.Books.demo.model.Authors;
import com.Books.demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, Integer> {
}
