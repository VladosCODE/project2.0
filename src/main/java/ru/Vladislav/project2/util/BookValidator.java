package ru.Vladislav.project2.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.Vladislav.project2.model.Book;
import ru.Vladislav.project2.service.BookService;

@Component
public class BookValidator implements Validator {

    private BookService bookService;

    @Autowired
    public BookValidator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if (bookService.findOne(book.getName()) != null){
            errors.rejectValue("name","","Такая книгу уже есть");
        }
    }
}
