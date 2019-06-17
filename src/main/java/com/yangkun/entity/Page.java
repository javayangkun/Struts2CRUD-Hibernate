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
		// �����һҳ����һҳ
		prev = p - 1;
		next = p + 1;
		// �����ʼ��,Ϊ��ҳ��ѯ��׼��
		startLine = (p - 1) * size;

		// ��������Ƿ��հٶȵķ�ҳ��
		// ������ҳ�����ж���ʼҳ�ͽ���ҳ
		if (maxPage < 10) {
			// ����ҳ��С��10ҳ��ʱ��
			startPage = 1;
			endPage = 10;
		} else {
			// ����ҳ������10ҳ��ʱ��
			startPage = p - 5;
			endPage = p + 4;
			// �����ʼҳС��1
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