package com.wt.tools;

import java.util.ArrayList;
import java.util.List;

public class Paging {
	private int num;//ÿҳ����������
	private int pageNum;//ҳ��
	private int nowPage;//��ǰ�ڼ�ҳ
	private int records;//�ܼ�¼��
	private List list;//�ܼ�¼
	
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
	 * �ж��Ƿ�����ҳ
	 */
	public boolean isFirstPage() {
		if(nowPage == 1){
			return true;
		}
		return false;
		
	}
	/**
	 * �ж��Ƿ���βҳ
	 */
	public boolean isLastPage() {
		if(nowPage == pageNum){
			return true;
		}
		return false;
		
	}
	/**
	 * ��һҳ
	 */
	public void prevPage() {
		if(!isFirstPage()){
			nowPage--;
		}
	}
	/**
	 * ��һҳ
	 */
	public void nextPage() {
		if(!isLastPage()){
			nowPage++;
		}
	}
	/**
	 * ��ȡ��ǰҳ�����м�¼
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
