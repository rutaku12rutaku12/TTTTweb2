package example.실습.실습3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class BooksDto {

            private int id;
            private String title;
            private int stock;

            private String member;
}
