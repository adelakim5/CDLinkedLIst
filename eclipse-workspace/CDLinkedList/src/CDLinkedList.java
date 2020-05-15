
public class CDLinkedList<T> implements ICircularDoubleLinkedList<T> {

	public CDNode<T> last;
	public int size;

	public CDLinkedList() {
		last = null;
		size = 0;
	}

	@Override
	public void insertAfter(T target, T data) {
		CDNode<T> newNode = new CDNode(null, data, null);
		if (size == 0 && target == null) {
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
		} else if (size == 0 && target != null) {
			System.out.println("No data! Insert your data (" + data + ") firstly.");
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
		} else {
			if (search(target)) {
				CDNode<T> t = findNode(target);
				t.getRlink().setLlink(newNode);
				newNode.setRlink(t.getRlink());
				t.setRlink(newNode);
				newNode.setLlink(t);
				size++;
			} else {
				System.out.println("Cannot find your target: " + target);
			}

		}

	}

	public CDNode<T> findNode(T target) {
		CDNode<T> t = last;
		for (int i = 0; i < size; i++) {
			if (target == t.data) {
				return t;
			}
			t = t.getRlink();
		}
		return t;
	}

	@Override
	public void insertPrevious(T target, T data) {
		CDNode<T> newNode = new CDNode(null, data, null);
		if (size == 0 && target == null) {
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
		} else if (size == 0 && target != null) {
			System.out.println("No data! Insert your data (" + data + ") firstly.");
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
		}
		if (search(target)) {
			CDNode<T> t = findNode(target);
			t.getLlink().setRlink(newNode);
			newNode.setLlink(t.getLlink());
			t.setLlink(newNode);
			newNode.setRlink(t);
			size++;

			if (t == last) {
				last = newNode;
			}
		} else {
			System.out.println("Cannot find your target: " + target);
		}

	}

	@Override
	public void removePrevious(T target) {
		if (size == 0) {
			System.out.println("No data! Cannot remove data.");
		} else if (size == 1 && !search(target) || size == 1 && search(target)) {
			System.out.println("There's only data: " + last.data + ", and remove it.");
			last.setLlink(null);
			last.setRlink(null);
			size--;
		} else {
			if (search(target)) {
				CDNode<T> t = findNode(target);
				CDNode<T> x = t.getLlink();
				if(x == last) {
					last = t;
				}
				t.setLlink(x.getLlink());
				x.getLlink().setRlink(t);
				x.setLlink(null);
				x.setRlink(null);
				size--;
			} else {
				System.out.println("There's no your target: " + target);
			}
		}

	}

	@Override
	public void removeAfter(T target) {
		if (size == 0) {
			System.out.println("No data! Cannot remove data.");
		} else if (size == 1 && !search(target) || size == 1 && search(target)) {
			System.out.println("There's only data: " + last.data + ", and remove it.");
			last.setLlink(null);
			last.setRlink(null);
			size--;
		} else {
			if (search(target)) {
				CDNode<T> t = findNode(target);
				CDNode<T> x = t.getRlink();
				if(x == last) {
					last = x.getRlink();
				}
				t.setRlink(x.getRlink());
				x.getRlink().setLlink(t);
				x.setRlink(null);
				x.setLlink(null);
				size--;
			} else {
				System.out.println("There's no your target: " + target);
			}
		}

	}

	@Override
	public boolean search(T data) {
		CDNode<T> t = last;
		for (int i = 0; i < size; i++) {
			if (data == t.data) {
				return true;
			}
			t = t.getRlink();
		}
		return false;
	}

	@Override
	public void printAll() {
		CDNode c = last;
		System.out.print("CDList = {");
		for (int i = 0; i < size; i++) {
			System.out.print(c.data + ", ");
			c = c.getRlink();
		}
		System.out.println("}");

	}
}
