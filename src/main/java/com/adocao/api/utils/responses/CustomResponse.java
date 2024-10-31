package com.adocao.api.utils.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse<T> {

    private int size;
    private int actualPage;
    private int totalPages;
    private T data;

    public CustomResponse(int size, int actualPage, int totalPages, T data) {
        this.size = size;
        this.actualPage = actualPage;
        this.totalPages = totalPages;
        this.data = data;
    }

}
