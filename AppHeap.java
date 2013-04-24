import java.util.Scanner;

public class AppHeap
{
	public static void main(String [] args)
	{

		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		int rooms = 0;
		String patientName = "";
		String malady = "";
		int priority = 0;


		System.out.println("Enter the number of patients on waiting list for operating room 1");
		rooms = scanInt.nextInt();
		Heap room1 = new Heap(rooms);
		System.out.println("Enter the number of patients on waiting list for operating room 2");
		rooms = scanInt.nextInt();
		Heap room2 = new Heap(rooms);

		while(!room1.isFull() && !room2.isFull())
		{
			System.out.println("Enter patient name");
			patientName = scanString.nextLine();
			System.out.println("Enter melady of the patient");
			malady = scanString.nextLine();
			System.out.println("Enter priority of the patient");
			priority = scanInt.nextInt();

			Patient patient = new Patient(patientName, malady, priority);


			if(!room1.isFull())
			{
				room1.add(patient);
				System.out.println("added room1");
			}
			else 
			{
				room2.add(patient);
				System.out.println("added room2");
			}
			
		}//while
		System.out.println("-- schedule for operating room 1 --");
		room1.remove();
		System.out.println("-- schedule for operating room 2 --");
		room2.remove();
	}
}