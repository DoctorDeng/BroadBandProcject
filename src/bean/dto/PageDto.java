package bean.dto;

import java.util.List;

public class PageDto<T> {
	//首页页码,默认为1
	private int indexPage = 1;
	//尾页页码
	private int endPage;
	//上一页
	private int upPage;
	//下一页
	private int nextPage;
	//当前页页码
	private int currentPage = 1;
	//页面大小--一页包含数据条数,默认为4
	private int pageSize = 4;
	//总的页数
	private int pageNum;
	//数据总条数
	private int recordNum;
	//定义一个通用的泛型，（泛型方法），存储每个页面的数据
	private List<T> dataList;

	public PageDto(){}
	
	/**
	 * 初始化PageDto数据的方法
	 * @param recordNum   数据总条数
	 * @param pageSize    页面数据条数
	 * @param currentPage 当前页页码
	 */
	public void init(int recordNum,int pageSize,String currentPagestr){
		this.pageSize    = pageSize;
		this.recordNum   = recordNum;
		this.pageNum     =  (int) Math.ceil((this.recordNum*1.0)/(this.pageSize*1.0));
		this.endPage     = this.pageNum;
		
		if (null != currentPagestr && !"".equals(currentPagestr)){
			this.currentPage = Integer.parseInt(currentPagestr);
		}
		
		if(this.currentPage > this.pageNum) {
			this.currentPage = this.pageNum;
		}
		
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		
		if(this.currentPage > this.pageNum) {
			this.currentPage = this.pageNum;
		}
		if (this.currentPage != 1 && this.pageNum > 1) {
  			this.upPage   = this.currentPage - 1; 
  		}
  		if (this.currentPage < this.pageNum && this.pageNum > 2) {
  			this.nextPage = this.currentPage + 1;
  		}
  		if (this.currentPage == this.pageNum) {
  			this.nextPage = this.pageNum;
  		}
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

	public int getUpPage() {
		return upPage;
	}

	public void setUpPage(int upPage) {
		this.upPage = upPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	
}
