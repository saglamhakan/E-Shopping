package demo.EShopping.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "categories1")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;

   // @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    //private List<Product> products;

}
