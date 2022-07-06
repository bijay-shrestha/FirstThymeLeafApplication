package edu.miu.firstthymeleafapplication.service.impl;

import edu.miu.firstthymeleafapplication.model.Book;
import edu.miu.firstthymeleafapplication.repository.BookRepository;
import edu.miu.firstthymeleafapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addNewBook(Book book) {
        return bookRepository.save(book);
    }
}
