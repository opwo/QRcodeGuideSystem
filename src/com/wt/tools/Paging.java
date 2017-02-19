package com.wt.tools;

import java.util.ArrayList;
import java.util.List;

public class Paging {
	private int num;//每页多少条数据
	private int pageNum;//页数
	private int nowPage;//当前第几页
	private int records;//总记录数
	private List list;//总记录
	
	public Paging(List list,int num){
		this.list=list;
		this.num=num;
		this.records = list.size();
		if(records%num==0){
			pageNum = records/num;
		}else{
			pageNum = records/num +1;
		}
		nowPage = 1;
	}
	/**
	 * 判断是否是首页
	 */
	public boolean isFirstPage() {
		if(nowPage == 1){
			return true;
		}
		return false;
		
	}
	/**
	 * 判断是否是尾页
	 */
	public boolean isLastPage() {
		if(nowPage == pageNum){
			return true;
		}
		return false;
		
	}
	/**
	 * 上一页
	 */
	public void prevPage() {
		if(!isFirstPage()){
			nowPage--;
		}
	}
	/**
	 * 下一页
	 */
	public void nextPage() {
		if(!isLastPage()){
			nowPage++;
		}
	}
	/**
	 * 获取当前页的所有记录
	 */
	public List getAllRecords() {
		List pageList = new ArrayList();
		int start = -1;
		int end = -1;
		if(list.size()==0){
			
		}else {
			start = (nowPage-1)*num;
			end = nowPage*num-1;
		}
		if(isLastPage()){
			end = records-1;
		}
		for(int i=start;i<=end;i++){
			pageList.add(list.get(i));
		}
		return pageList;
	}
}
