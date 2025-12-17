package com.college.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


@Entity
@Data

public class Library {
    @Id
    private int bookNo;
    @NotBlank
    @NotNull
    private String bookName;
    private String author;
    @Column(unique = true)
    private int shelfId;

}