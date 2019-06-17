package com.yangkun.entity;

import java.util.List;

public class Page<T> {
	private Integer size;// 每页要显示的行数
	private Integer p; // 当前页
	private Integer rowCount;// 总行数
	private Integer maxPage;// 总页数
	private Integer prev; // 上一页
	private Integer next;// 下一页
	private Integer startLine;// 起始行
	private Integer startPage;// 起始页
	private Integer endPage;// 结束页
	private List<T> list; // 分页数据

	public Page(Integer size, Integer p, Integer rowCount) {
		super();
		this.size = size;
		this.p = p;
		this.rowCount = rowCount;
		maxPage = (int) Math.ceil(rowCount * 1.0 / size);
		// 利用总页数，把当前页数限定在有效范围内
		if (p > maxPage)
			p = maxPage;
		if (p < 1)
			p = 1;
		// 求出上一页和下一页
		prev = p - 1;
		next = p + 1;
		// 求出起始行,为分页查询做准备
		startLine = (p - 1) * size;

		// 下面这个是仿照百度的分页栏
		// 根据总页数来判断起始页和结束页
		if (maxPage < 10) {
			// 当总页数小于10页的时候
			startPage = 1;
			endPage = 10;
		} else {
			// 当总页数大于10页的时候
			startPage = p - 5;
			endPage = p + 4;
			// 如果起始页小于1
			if (startPage < 1) {
				startPage = 1;
				endPage = 10;
			}

			if (endPage > maxPage) {
				startPage = maxPage - 9;
				endPage = maxPage;
			}
		}
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getP() {
		return p;
	}

	public void setP(Integer p) {
		this.p = p;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public Integer getPrev() {
		return prev;
	}

	public void setPrev(Integer prev) {
		this.prev = prev;
	}

	public Integer getNext() {
		return next;
	}

	public void setNext(Integer next) {
		this.next = next;
	}

	public Integer getStartLine() {
		return startLine;
	}

	public void setStartLine(Integer startLine) {
		this.startLine = startLine;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [size=" + size + ", p=" + p + ", rowCount=" + rowCount + ", maxPage=" + maxPage + ", prev=" + prev
				+ ", next=" + next + ", startLine=" + startLine + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", list=" + list + "]";
	}

}