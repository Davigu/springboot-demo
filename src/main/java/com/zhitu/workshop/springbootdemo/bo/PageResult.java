package com.zhitu.workshop.springbootdemo.bo;

import java.awt.*;

public class PageResult {
    private List list; //装分页列表中的内容
    private Integer firstPage; //第一页
    private Integer prePage; //上一页
    private Integer nextPage;//下一页
    private Integer currentPage;//当前页面
    private Integer totalPage; //总页数/尾页
    private Integer count;//总条数
    private Integer size; //每页多少条
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }
    public Integer getFirstPage() {
        return firstPage;
    }
    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }
    public Integer getPrePage() {
        return (this.currentPage-1==0?1:this.currentPage-1);
    }
    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }
    public Integer getNextPage() {
        return (this.currentPage==this.totalPage?this.totalPage:this.currentPage+1);
    }
    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getTotalPage() {
        return (this.count%this.size==0?this.count/this.size:this.count/this.size+1);
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }
}