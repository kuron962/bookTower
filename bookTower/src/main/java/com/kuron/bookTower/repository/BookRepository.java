package com.kuron.bookTower.repository;

import com.kuron.bookTower.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
