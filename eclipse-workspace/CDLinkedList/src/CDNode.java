
public class CDNode<T> {
	
	public T data;
	public CDNode<T> rlink;
	public CDNode<T> llink;
	
	public CDNode(CDNode<T> llink, T data, CDNode<T> rlink) {
		this.data = data;
		this.llink = llink;
		this.rlink = rlink;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public CDNode<T> getRlink() {
		return rlink;
	}

	public void setRlink(CDNode<T> rlink) {
		this.rlink = rlink;
	}

	public CDNode<T> getLlink() {
		return llink;
	}

	public void setLlink(CDNode<T> llink) {
		this.llink = llink;
	}
	
	

}
