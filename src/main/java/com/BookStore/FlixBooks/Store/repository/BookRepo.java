package com.BookStore.FlixBooks.Store.repository;

import com.BookStore.FlixBooks.Store.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    //Shift + command and T for new test
}
