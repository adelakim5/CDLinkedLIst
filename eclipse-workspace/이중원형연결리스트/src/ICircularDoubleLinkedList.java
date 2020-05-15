
public interface ICircularDoubleLinkedList<T> {
	public void insertAfter(T target, T data);
	public void insertPrevious(T target, T data);
	public void removeAfter(T target);
	public void removePrevious(T target);
	public boolean search(T data);
	public void printAll();
}
