
public class CDLinkedList<T> implements ICircularDoubleLinkedList<T> {

	public CDNode<T> last;
	public int size;

	public CDLinkedList() {
		last = null;
		size = 0;
	}

	@Override
	public void insertAfter(T target, T data) {
//		노드 생성
		CDNode<T> newNode = new CDNode(null, data, null);
		if (size == 0 && target == null) {
//			리스트에 노드가 없으면 && target도 마침 null이면 
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
//			자기 자신을 도는 방향으로 list에 담기 
		} else if (size == 0 && target != null) {
//			리스트에 노드 없는데 어떤 target을 부르면 
			System.out.println("No data! Insert your data(" + data + ") firstly.");
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
//			타겟 없다고 알려주고 그 노드를 list에 담기
		} else {
//			타겟을 찾아야 함. 그럼 타겟 찾는 코드 작성해주기 
			if (search(target)) {
//				만약 target이 있으면 
//				target을 찾기 
				CDNode<T> t = findNode(target);
//				target 뒤에 있는 애의 llink를 newNode로
				t.getRlink().setLlink(newNode);
//				newNode의 rlink를 target 뒤에 있는 애로 
				newNode.setRlink(t.getRlink());
//				target의 뒤를 newNode로
				t.setRlink(newNode);
//				newNode 앞에 target이 오도록 
				newNode.setLlink(t);
//				size 추가 
				size++;
			} else {
//				만약 target이 없으면
				System.out.println("Cannot find your target: " + target);
			}
		}

	}

	public CDNode<T> findNode(T target) {
		CDNode<T> t = last;
//		last에서부터 시작하게 
		for (int i = 0; i < size; i++) {
//			전체 사이즈 만큼 돌면서 
			if (target == t.data) {
				return t;
			}
//			t의 data가 target이랑 같으면 t를 반환 
			t = t.getRlink();
//			계속 오른쪽 링크로 돌면서 찾기 
		}
		return t;
	}

	@Override
	public void insertPrevious(T target, T data) {
		CDNode<T> newNode = new CDNode(null, data, null);
//		insertAfter와 원리 같음. 다만 그 앞에 넣는거니까 그 부분만 건드려주면 됨
		if (size == 0 && target == null) {
//			리스트에 노드가 없으면 && target도 마침 null이면 
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
//			자기 자신을 도는 방향으로 list에 담기 
		} else if (size == 0 && target != null) {
//			리스트에 노드 없는데 어떤 target을 부르면 
			System.out.println("No data! Insert your data(" + data + ") firstly.");
			newNode.setLlink(newNode);
			newNode.setRlink(newNode);
			last = newNode;
			size++;
//			타겟 없다고 알려주고 그 노드를 list에 담기
		} else {
//			타겟을 찾아야 함. 그럼 타겟 찾는 코드 작성해주기 
			if (search(target)) {
//				만약 target이 있으면 
//				target을 찾기 
				CDNode<T> t = findNode(target);
//				target 앞에 있는 애의 rlink를 newNode로
				t.getLlink().setRlink(newNode);
//					newNode의 llink를 target 앞에 있는 애로 
				newNode.setLlink(t.getLlink());
//					target의 앞를 newNode로
				t.setLlink(newNode);
//					newNode 뒤에 target이 오도록 
				newNode.setRlink(t);
//					size 추가 
				size++;
				if (t == last) {
					last = newNode;
				}
			} else {
//				만약 target이 없으면
				System.out.println("Cannot find your target: " + target);
			}
		}

	}

	@Override
	public void removePrevious(T target) {
//		노드 생성할 필요가 없지
//		list가 비었는지 확인 
		if (size == 0) {
			System.out.println("No data! Cannnot remove data.");
		} else if (size == 1 && !search(target) || size == 1 && search(target)) {
//			target은 없는데 size가 하나면  || target있는데 size가 하나면, 즉 target만 있으면
			System.out.println("There's only data: " + last.data + ", and remove it.");
			last.setLlink(null);
			last.setRlink(null);
			size--;
		} else {
//			target이 있고, 사이즈도 여러개라면 
			if (search(target)) {
				CDNode<T> t = findNode(target);
				CDNode<T> x = t.getLlink();
//				삭제하려는 노드를 변수 x에 담음 
				if (x == last) {
//					만약 x가 last라면 
					last = t;
//					last뒤에 있는 target이 last가 되도록 해줌 
				}
				t.setLlink(x.getLlink());
//				target앞에 x 앞에 있는 노드가 오도록 
				x.getLlink().setRlink(t);
//				x 앞에 있는 노드 뒤에 target이 오도록 
				x.setLlink(null);
				x.setRlink(null);
//				x의 연결을 끊어줌 
				size--;
			} else {
//				target이 없으면 
				System.out.println("There's no your target: " + target);
			}
		}
	}

	@Override
	public void removeAfter(T target) {
//		노드 생성할 필요가 없지
//		list가 비었는지 확인 
		if (size == 0) {
			System.out.println("No data! Cannnot remove data.");
		} else if (size == 1 && !search(target) || size == 1 && search(target)) {
//			target은 없는데 size가 하나면  || target있는데 size가 하나면, 즉 target만 있으면
			System.out.println("There's only data: " + last.data + ", and remove it.");
			last.setLlink(null);
			last.setRlink(null);
			size--;
		} else {
//			target이 있고, 사이즈도 여러개라면 
			if (search(target)) {
				CDNode<T> t = findNode(target);
				CDNode<T> x = t.getRlink();
				if (x == last) {
//					삭제하려는 x가 last라면 
					last = x.getRlink();
//					x 다음에 오는 노드를 last로 
				}
				t.setRlink(x.getRlink());
//				target의 다음에 x의 다음 노드가 오도록 
				x.getRlink().setLlink(t);
//				x 다음 노드의 전에 target이 오도록 
				x.setLlink(null);
				x.setRlink(null);
//				x의 연결을 끊어줌 
				size--;
			} else {
//				target이 없으면 
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
//		반만 도는게 더 낫지 않나? 반까지만 rlink돌고 없으면 llink?
		/*
		 * for (int i = 0; i < size; i++) { if (data == t.data) { return true; } t =
		 * t.getRlink(); }
		 */

		if (size % 2 == 0) { // 사이즈가 짝수면
			if (isRight(data, size / 2) == 1)
				return true;
			else if (isLeft(data, size / 2) == 1)
				return true;

		} else { // 사이즈가 홀수면
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
