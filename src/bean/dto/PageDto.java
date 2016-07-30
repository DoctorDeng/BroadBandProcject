package bean.dto;

import java.util.List;

public class PageDto<T> {
	//首页页码
	private int indexPage;
	//尾页页码
	private int endPage;
	//当前页页码
	private int currentPage;
	//页面大小--一页包含数据条数
	private int pageSize;
	//总的页数
	private int pageNum;
	//数据总条数
	private int recordNum;
	//定义一个通用的泛型，（泛型方法），存储每个页面的数据
	private List<T> dataList;

	public PageDto(){}
	
	public PageDto(int indexPage, int endPage, int currentPage, int pageSize, int pageNum, int recordNum,
			List<T> dataList) {
		super();
		this.indexPage = indexPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.recordNum = recordNum;
		this.dataList = dataList;
	}


	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	
}
