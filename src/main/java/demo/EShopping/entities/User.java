package demo.EShopping.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;

    private String password;
}
