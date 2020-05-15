
public class CDLinkedList<T> implements ICircularDoubleLinkedList<T> {

	public CDNode<T> last;
	public int size;

	public CDLinkedList() {
		last = null;
		size = 0;
	}

	@Override
	public void insertAfter(T target, T data) {
//		��� ����
		CDNode<T> newNode = new CDNode(null, data, null);
		if (size == 0 && target == null) {
//			����Ʈ�� ��尡 ������ && target�� ��ħ null�̸� 
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
//			�ڱ� �ڽ��� ���� �������� list�� ��� 
		} else if (size == 0 && target != null) {
//			����Ʈ�� ��� ���µ� � target�� �θ��� 
			System.out.println("No data! Insert your data(" + data + ") firstly.");
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
//			Ÿ�� ���ٰ� �˷��ְ� �� ��带 list�� ���
		} else {
//			Ÿ���� ã�ƾ� ��. �׷� Ÿ�� ã�� �ڵ� �ۼ����ֱ� 
			if (search(target)) {
//				���� target�� ������ 
//				target�� ã�� 
				CDNode<T> t = findNode(target);
//				target �ڿ� �ִ� ���� llink�� newNode��
				t.getRlink().setLlink(newNode);
//				newNode�� rlink�� target �ڿ� �ִ� �ַ� 
				newNode.setRlink(t.getRlink());
//				target�� �ڸ� newNode��
				t.setRlink(newNode);
//				newNode �տ� target�� ������ 
				newNode.setLlink(t);
//				size �߰� 
				size++;
			} else {
//				���� target�� ������
				System.out.println("Cannot find your target: " + target);
			}
		}

	}

	public CDNode<T> findNode(T target) {
		CDNode<T> t = last;
//		last�������� �����ϰ� 
		for (int i = 0; i < size; i++) {
//			��ü ������ ��ŭ ���鼭 
			if (target == t.data) {
				return t;
			}
//			t�� data�� target�̶� ������ t�� ��ȯ 
			t = t.getRlink();
//			��� ������ ��ũ�� ���鼭 ã�� 
		}
		return t;
	}

	@Override
	public void insertPrevious(T target, T data) {
		CDNode<T> newNode = new CDNode(null, data, null);
//		insertAfter�� ���� ����. �ٸ� �� �տ� �ִ°Ŵϱ� �� �κи� �ǵ���ָ� ��
		if (size == 0 && target == null) {
//			����Ʈ�� ��尡 ������ && target�� ��ħ null�̸� 
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
//			�ڱ� �ڽ��� ���� �������� list�� ��� 
		} else if (size == 0 && target != null) {
//			����Ʈ�� ��� ���µ� � target�� �θ��� 
			System.out.println("No data! Insert your data(" + data + ") firstly.");
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
//			Ÿ�� ���ٰ� �˷��ְ� �� ��带 list�� ���
		} else {
//			Ÿ���� ã�ƾ� ��. �׷� Ÿ�� ã�� �ڵ� �ۼ����ֱ� 
			if (search(target)) {
//				���� target�� ������ 
//				target�� ã�� 
				CDNode<T> t = findNode(target);
//				target �տ� �ִ� ���� rlink�� newNode��
				t.getLlink().setRlink(newNode);
//					newNode�� llink�� target �տ� �ִ� �ַ� 
				newNode.setLlink(t.getLlink());
//					target�� �ո� newNode��
				t.setLlink(newNode);
//					newNode �ڿ� target�� ������ 
				newNode.setRlink(t);
//					size �߰� 
				size++;
				if (t == last) {
					last = newNode;
				}
			} else {
//				���� target�� ������
				System.out.println("Cannot find your target: " + target);
			}
		}

	}

	@Override
	public void removePrevious(T target) {
//		��� ������ �ʿ䰡 ����
//		list�� ������� Ȯ�� 
		if (size == 0) {
			System.out.println("No data! Cannnot remove data.");
		} else if (size == 1 && !search(target) || size == 1 && search(target)) {
//			target�� ���µ� size�� �ϳ���  || target�ִµ� size�� �ϳ���, �� target�� ������
			System.out.println("There's only data: " + last.data + ", and remove it.");
			last.setLlink(null);
			last.setRlink(null);
			size--;
		} else {
//			target�� �ְ�, ����� ��������� 
			if (search(target)) {
				CDNode<T> t = findNode(target);
				CDNode<T> x = t.getLlink();
//				�����Ϸ��� ��带 ���� x�� ���� 
				if (x == last) {
//					���� x�� last��� 
					last = t;
//					last�ڿ� �ִ� target�� last�� �ǵ��� ���� 
				}
				t.setLlink(x.getLlink());
//				target�տ� x �տ� �ִ� ��尡 ������ 
				x.getLlink().setRlink(t);
//				x �տ� �ִ� ��� �ڿ� target�� ������ 
				x.setLlink(null);
				x.setRlink(null);
//				x�� ������ ������ 
				size--;
			} else {
//				target�� ������ 
				System.out.println("There's no your target: " + target);
			}
		}
	}

	@Override
	public void removeAfter(T target) {
//		��� ������ �ʿ䰡 ����
//		list�� ������� Ȯ�� 
		if (size == 0) {
			System.out.println("No data! Cannnot remove data.");
		} else if (size == 1 && !search(target) || size == 1 && search(target)) {
//			target�� ���µ� size�� �ϳ���  || target�ִµ� size�� �ϳ���, �� target�� ������
			System.out.println("There's only data: " + last.data + ", and remove it.");
			last.setLlink(null);
			last.setRlink(null);
			size--;
		} else {
//			target�� �ְ�, ����� ��������� 
			if (search(target)) {
				CDNode<T> t = findNode(target);
				CDNode<T> x = t.getRlink();
				if (x == last) {
//					�����Ϸ��� x�� last��� 
					last = x.getRlink();
//					x ������ ���� ��带 last�� 
				}
				t.setRlink(x.getRlink());
//				target�� ������ x�� ���� ��尡 ������ 
				x.getRlink().setLlink(t);
//				x ���� ����� ���� target�� ������ 
				x.setLlink(null);
				x.setRlink(null);
//				x�� ������ ������ 
				size--;
			} else {
//				target�� ������ 
				System.out.println("There's no your target: " + target);
			}
		}

	}

	public int isRight(T data, int halfSize) {
		CDNode<T> t = last;
		for (int i = 0; i < halfSize; i++) {
			if (data == t.data) {
				return 1;
			}
			t = t.getRlink();
		}
		return -1;
	}

	public int isLeft(T data, int halfSize) {
		CDNode<T> t = last;
		for (int i = 0; i < halfSize; i++) {
			if (data == t.data) {
				return 1;
			}
			t = t.getLlink();
		}
		return -1;
	}

	@Override
	public boolean search(T data) {
		CDNode<T> t = last;
//		�ݸ� ���°� �� ���� �ʳ�? �ݱ����� rlink���� ������ llink?
		/*
		 * for (int i = 0; i < size; i++) { if (data == t.data) { return true; } t =
		 * t.getRlink(); }
		 */

		if (size % 2 == 0) { // ����� ¦����
			if (isRight(data, size / 2) == 1)
				return true;
			else if (isLeft(data, size / 2) == 1)
				return true;

		} else { // ����� Ȧ����
			if (isRight(data, (int) Math.floor(size / 2)) == 1)
				return true;
			else if (isLeft(data, (int) Math.floor(size / 2) + 1) == 1)
				return true;
		}

		return false;
	}

	@Override
	public void printAll() {
		CDNode c = last;
		System.out.print("CDList = { ");
		for (int i = 0; i < size; i++) {
			System.out.print(c.data + ", ");
			c = c.getRlink();
		}
		System.out.println("}");
	}

}
