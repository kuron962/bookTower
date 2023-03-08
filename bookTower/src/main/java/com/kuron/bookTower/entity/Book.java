package com.kuron.bookTower.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    // 本のタイトルを保持するフィールド
    private String title;

    @Column
    // 本の値段を保持するフィールド
    private String  category;

    @Column
    private String status;
}
