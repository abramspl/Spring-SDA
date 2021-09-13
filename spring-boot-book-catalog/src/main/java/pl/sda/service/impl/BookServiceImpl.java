package pl.sda.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sda.dto.BookDto;
import pl.sda.mapper.BookMapper;
import pl.sda.model.Book;
import pl.sda.repository.BookRepository;
import pl.sda.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getById(Integer id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> getAllDto() {
        return getAllPaginated(0,2)
                .stream()
                .map(b -> BookMapper.map(b))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllPaginated(Integer pageNumber, Integer bookQuantity) {
        final PageRequest pageRequest = PageRequest.of(pageNumber, bookQuantity, Sort.by("title"));
        return bookRepository.findAll(pageRequest).getContent();
    }
}
