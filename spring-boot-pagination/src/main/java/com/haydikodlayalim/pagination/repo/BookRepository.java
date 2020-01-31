package com.haydikodlayalim.pagination.repo;

import com.haydikodlayalim.pagination.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
