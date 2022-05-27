package me.whiteship.di;

import org.junit.Assert;
import org.junit.Test;

public class ContainerServiceTest {


    @Test
    public void getObject_bookRepository() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        Assert.assertNotNull(bookRepository);
    }

    @Test
    public void getObject_bookService() {
        BookService bookService = ContainerService.getObject(BookService.class);
        Assert.assertNotNull(bookService);
        Assert.assertNotNull(bookService.bookRepository);

    }
}