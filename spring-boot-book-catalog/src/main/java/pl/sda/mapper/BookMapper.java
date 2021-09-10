package pl.sda.mapper;

import pl.sda.dto.BookDto;
import pl.sda.model.Book;

public final class BookMapper {

    private BookMapper() {

    }

    public static BookDto map(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor());
    }

}
