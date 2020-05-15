
public class CDLinkedListTest {

	public static void main(String[] args) {
		CDLinkedList cdl = new CDLinkedList();
		cdl.insertPrevious("월", "일");
		cdl.printAll();
		cdl.insertAfter("일", "월");
		cdl.printAll();
		cdl.insertPrevious("일", "토");
		cdl.printAll();
		cdl.insertAfter("화", "수");
		cdl.printAll();
		cdl.insertPrevious("토", "금");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.insertAfter("월", "화");
		cdl.printAll();
		cdl.insertPrevious("금", "목");
		cdl.printAll();
		cdl.insertAfter("수", "수");
		cdl.printAll();
		cdl.insertAfter("화", "수");
		cdl.printAll();
		System.out.println("last의 llink: " + cdl.last.getLlink().getData());
		System.out.println("last의 rlink: " + cdl.last.getRlink().getData());
		cdl.removeAfter("목");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removeAfter("수");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removePrevious("수");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removePrevious("일");
		cdl.printAll();
		System.out.println("last: " + cdl.last.data);
		cdl.removePrevious("일");
		cdl.printAll();
		cdl.removePrevious("일");
		cdl.printAll();
		cdl.removePrevious("일");
		cdl.printAll();
		cdl.removePrevious("일");
		cdl.printAll();
	}

}
