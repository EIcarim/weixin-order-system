package com.hmtech.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class CategoryForm {

    private Integer categoryId;

    @NotEmpty(message = "类目名称必填")
    private String categoryName;

    @NotNull(message = "type必填")
    private Integer categoryType;

}
