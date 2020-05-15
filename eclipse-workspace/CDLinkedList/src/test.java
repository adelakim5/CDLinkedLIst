
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CDLinkedList cdl = new CDLinkedList();
		cdl.insertAfter("화", "월");
		cdl.printAll();
		cdl.insertPrevious("월", "금");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removeAfter("금");
		cdl.printAll();
		cdl.insertAfter("금", "토");
		cdl.printAll();
		cdl.removePrevious("토");
		cdl.printAll();
	}

}
