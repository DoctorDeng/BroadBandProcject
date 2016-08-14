package bean;

public class Page {
	//Limit分页开始位置
	private int index;
	//Limit分页数据条数
	private int size;
	
	public Page(){}
	
	public Page(int index, int size) {
		super();
		this.index = index;
		this.size = size;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
