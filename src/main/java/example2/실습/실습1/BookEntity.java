package example2.실습.실습1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BookEntity {
    @Id
    private int book_id;
    private String book_name;
    private String book_author;
    private String book_publisher;
}
