package edu.miu.firstthymeleafapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
@NamedQuery(name="Book.findBookByISBN", query="select b from Book b where b.isbn = ?1")
@NamedNativeQuery(name="Book.cheapBooks", query="select * from books b where b.price < ?1")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name="isbn", nullable = false, unique = true)
    @NotBlank(message = "ISBN cannot be blank, empty of null")
    private String isbn;
    private String title;
    private LocalDate datePubished;
    private Integer numberOfCopies;
    private Double price;
    @ManyToOne
    @JoinColumn(name="publisher_id", nullable = true)
    private Publisher publisher;
    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(name="book_id", referencedColumnName = "bookId")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "authorId")}
    )
    private List<Author> authors;

}
