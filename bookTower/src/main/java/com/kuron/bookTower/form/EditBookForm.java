package com.kuron.bookTower.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EditBookForm {

    @NotNull(message="IDがNullになっています")
    private Integer id;

    @NotBlank(message="タイトルを入力してください。")
    private String title;

    private String category;

    private String status;
}
