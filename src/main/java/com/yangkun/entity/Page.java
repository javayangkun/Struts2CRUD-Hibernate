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

}