package com.opslab.workflow.framework.entity;

import java.util.ArrayList;
import java.util.List;

import com.opslab.workflow.APP;


/**
 * 一个分页对象
 */
public class Page {
    // 要返回的某一页的记录列表
    
    
    private List<Object> list = new ArrayList<Object>();

    // 总记录数
    private int allRow = 0;


    // 总页数
    private int totalPage = 0;

    // 当前页
    private int currentPage = 1;

    // 每页记录数
    private int pageSize = APP.PAGE_SIZE;


    private int offset = 1;

    public void setCurrentPage( int p ) {
        if (p <= 0) {
            this.currentPage = 1;
        } else {
            this.currentPage = p;
        }
    }


    public void init() {
        totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
        offset = pageSize * (currentPage - 1);
    }

    @Override
    public String toString() {
        int size = 0;
        if (list != null) {
            size = list.size();
        }
        return "Page{" +
                "list.size()=" + size +
                ", allRow=" + allRow +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                '}';
    }


	public List<Object> getList() {
		return list;
	}


	public void setList(List<Object> list) {
		this.list = list;
	}


	public int getAllRow() {
		return allRow;
	}


	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public int getCurrentPage() {
		return currentPage;
	}


    
}
