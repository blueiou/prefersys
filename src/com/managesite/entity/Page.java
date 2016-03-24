package com.managesite.entity;

import java.io.Serializable;
import java.util.List;


public class Page implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 5824829857311771056L;
private	int	pagecount ;//ÿҳ��¼��
private	int	 pageno ;//��ǰҳ
private	int	 pagesize ;
private	int	pagelast ;
private	int	 pageNext ;
private	List newslist;
private int rowcount;
//private String sbB;

//��ҳ������

private String sb2;


public String getSb2() {
	return sb2;
}
public void setSb2(String sb2) {
	this.sb2 = sb2;
}

public int getRowcount() {
	return rowcount;
}
public void setRowcount(int rowcount) {
	this.rowcount = rowcount;
}
public Page(){
	
}

public int getPagecount() {
	return pagecount;
}

public void setPagecount(int pagecount) {
	this.pagecount = pagecount;
}
public int getPageno() {
	return pageno;
}
public void setPageno(int pageno) {
	this.pageno = pageno;
}
public int getPagesize() {
	return pagesize;
}
public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
}
public int getPagelast() {
	return pagelast;
}
public void setPagelast(int pagelast) {
	this.pagelast = pagelast;
}
public int getPageNext() {
	return pageNext;
}
public void setPageNext(int pageNext) {
	this.pageNext = pageNext;
}

public List getNewslist() {
	return newslist;
}
public void setNewslist(List newslist) {
	this.newslist = newslist;
}
public Page(int pagecount, int pageno, int pagesize, List newslist, int rowcount, String sb2) {
	super();
	this.pagecount = pagecount;
	this.pageno = pageno;
	this.pagesize = pagesize;
	this.newslist = newslist;
	this.rowcount = rowcount;
	this.sb2 = sb2;
}
public Page(int pagecount, int pageno, int pagesize, List newslist, int rowcount) {
	super();
	this.pagecount = pagecount;
	this.pageno = pageno;
	this.pagesize = pagesize;
	this.newslist = newslist;
	this.rowcount = rowcount;
}



}
