package example.실습.실습3.controller;

import example.실습.실습3.model.dto.BooksDto;
import example.실습.실습3.model.dto.RentalsDto;
import example.실습.실습3.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/rent")
    public boolean rent(
            @RequestBody RentalsDto rentalsDto
            ){ return bookService.rending( rentalsDto );
    }

    @PostMapping("/return")
    public boolean return1(
            @RequestBody RentalsDto rentalsDto
    ){ return bookService.returning( rentalsDto );
    }


} // class end
