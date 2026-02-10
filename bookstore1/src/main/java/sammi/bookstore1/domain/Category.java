package sammi.bookstore1.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryid;

    private String name;

    @OneToMany(
        mappedBy = "category",
        cascade = CascadeType.ALL
        
    )
    private List<Book> books;

  
    public Category() {}

    public Category(String name) {
        this.name = name;
    }


    public Long getCategoryid() {
        return categoryid;
    }

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
