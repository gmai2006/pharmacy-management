package com.datascience9.pharmacy.api.manual;

import java.util.List;

public class PageResponse<T> {
    public List<T> content;
    public long totalElements;
    public int totalPages;
    public int page;
    public int size;
    public boolean hasNext;
    public boolean hasPrevious;

    public PageResponse() {}
}
