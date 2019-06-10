package com.yangkun.entity;

import java.util.List;

public class Page<T> {
	private Integer size;// ÿҳҪ��ʾ������
	private Integer p; // ��ǰҳ
	private Integer rowCount;// ������
	private Integer maxPage;// ��ҳ��
	private Integer prev; // ��һҳ
	private Integer next;// ��һҳ
	private Integer startLine;// ��ʼ��
	private Integer startPage;// ��ʼҳ
	private Integer endPage;// ����ҳ
	private List<T> list; // ��ҳ����

	public Page(Integer size, Integer p, Integer rowCount) {
		super();
		this.size = size;
		this.p = p;
		this.rowCount = rowCount;
		maxPage = (int) Math.ceil(rowCount * 1.0 / size);
		// ������ҳ�����ѵ�ǰҳ���޶�����Ч��Χ��
		if (p > maxPage)
			p = maxPage;
		if (p < 1)
			p = 1;

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

}