package com.xsy.domain;

public class Page {

    private int pageNum;
    private int pageSize;
    private int tid;
    public Page(){


    }

    public int getPageNum() {
        return pageNum;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
