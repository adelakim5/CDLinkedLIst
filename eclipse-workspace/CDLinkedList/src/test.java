
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CDLinkedList cdl = new CDLinkedList();
		cdl.insertAfter("ȭ", "��");
		cdl.printAll();
		cdl.insertPrevious("��", "��");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removeAfter("��");
		cdl.printAll();
		cdl.insertAfter("��", "��");
		cdl.printAll();
		cdl.removePrevious("��");
		cdl.printAll();
	}

}
