package pl.sda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private Integer id;

    private String title;

    private String author;

}
