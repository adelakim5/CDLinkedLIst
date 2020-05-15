
public class CDLinkedListTest {

	public static void main(String[] args) {
		CDLinkedList cdl = new CDLinkedList();
		cdl.insertPrevious("��", "��");
		cdl.printAll();
		cdl.insertAfter("��", "��");
		cdl.printAll();
		cdl.insertPrevious("��", "��");
		cdl.printAll();
		cdl.insertAfter("ȭ", "��");
		cdl.printAll();
		cdl.insertPrevious("��", "��");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.insertAfter("��", "ȭ");
		cdl.printAll();
		cdl.insertPrevious("��", "��");
		cdl.printAll();
		cdl.insertAfter("��", "��");
		cdl.printAll();
		cdl.insertAfter("ȭ", "��");
		cdl.printAll();
		System.out.println("last�� llink: " + cdl.last.getLlink().getData());
		System.out.println("last�� rlink: " + cdl.last.getRlink().getData());
		cdl.removeAfter("��");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removeAfter("��");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removePrevious("��");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removePrevious("��");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removePrevious("��");
		cdl.printAll();
		cdl.removePrevious("��");
		cdl.printAll();
		cdl.removePrevious("��");
		cdl.printAll();
		cdl.removePrevious("��");
		cdl.printAll();
	}

}
