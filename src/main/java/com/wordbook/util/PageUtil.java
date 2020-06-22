package com.wordbook.util;

import java.io.Serializable;

public class PageUtil implements Serializable {
    private Integer page = 1;
    private Integer limit = 100;
    private Integer start;
    private Integer end;
    private Integer total;

    public PageUtil() {
    }

    public PageUtil(Integer page, Integer limit) {
        if (page != null && limit != null) {
            this.page = page;
            this.limit = limit;
        }
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStart() {
        return this.start = (this.page - 1) * this.limit;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return this.end = this.page * this.limit;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", limit=" + limit +
                ", start=" + start +
                ", end=" + end +
                ", total=" + total +
                '}';
    }
}
