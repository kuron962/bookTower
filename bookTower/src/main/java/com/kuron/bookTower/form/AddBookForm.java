package com.kuron.bookTower.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddBookForm {

    @NotBlank(message="タイトルを入力してください。")
    private String title;

    private String category;

    private String status;
}
