
public class TestHeap
{
	public static void main(String [] args)
	{
		Heap hList1 = new Heap(5);
		Patient p1 = new Patient("A", "cold",1);
		hList1.add(p1);
		Patient p5 = new Patient("E", "cold",5);
		hList1.add(p5);
		Patient p2 = new Patient("B", "cold",2);
		hList1.add(p2);
		Patient p4 = new Patient("D", "cold",4);
		hList1.add(p4);
		Patient p3 = new Patient("C", "cold",3);
		hList1.add(p3);

		System.out.println("getting into toString");
		System.out.println("1st: \n" + hList1.toString());
		
		Patient deletedPatient = hList1.remove();
		System.out.println("2nd: \n" + hList1.toString());
		deletedPatient = hList1.remove();
		
		System.out.println("3rd: \n" +hList1.toString());
		deletedPatient = hList1.remove();
		System.out.println("4th: \n" + hList1.toString());
		
	}
}
