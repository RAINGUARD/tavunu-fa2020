import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tribe {
	private static ArrayList<Tavunu> theTribe = new ArrayList<>();
	private static File f1 = new File("C:\\saveFile.ser");
	private static boolean exitLoop = false;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(exitLoop == false) {
			displayMenu();
			String input = s.nextLine();
			if(input.equalsIgnoreCase("a")) {
				add();
			} else if(input.equalsIgnoreCase("r")) {
				remove();
			} else if(input.equalsIgnoreCase("d")) {
				display();
			} else if(input.equalsIgnoreCase("s")) {
				try {
					save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if(input.equalsIgnoreCase("o")) {
				try {
					open();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if(input.equalsIgnoreCase("q")) {
				quit();
			} else {
				System.out.println("Not a valid command.");
			}
		}
	}
	
	public static void add() {
		Scanner s = new Scanner(System.in);
		Tavunu t;
		System.out.println("Enter name of Tavunu: ");
		String name = s.nextLine();
		System.out.println("Enter birth year: ");
		int year = Integer.parseInt(s.nextLine());
		System.out.println("Enter pava count: ");
		int pava = Integer.parseInt(s.nextLine());
		if(pava<21) {
			t = new Avo(name, year, pava);
		} else if(pava<81) {
			t = new Beele(name, year, pava);
		} else {
			if(year%2 == 0) {
				t = new CrodeExalted(name, year, pava);
			} else {
				t = new Crode(name, year, pava);
			}
		}
		theTribe.add(t);
	}
	
	public static void remove() {
		System.out.println("Enter name of Tavunu to remove: ");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		for(int i = 0; i<theTribe.size(); i++) {
			if(name.equalsIgnoreCase(theTribe.get(i).getName())) {
				theTribe.remove(i);
			}
		}
	}
	
	public static void display() {
		System.out.println("\n");
		int pava = 0;
		for(int i = 0; i<theTribe.size(); i++) {
			System.out.println(theTribe.get(i).getName());
			pava+=theTribe.get(i).getPava();
		}
		System.out.println("Members in the tribe: "+theTribe.size());
		System.out.println("Total pava held by tribe: "+pava+"\n");
	}
	
	public static void save() throws IOException {
		try {

		    //Write Student array to file.
		    FileOutputStream fos = new FileOutputStream("saveFile.ser");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(theTribe);
		    oos.close();

		    
		}
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static void open() throws IOException {
		//Read Student array from file.
	    FileInputStream fis = new FileInputStream("saveFile.ser");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    try {
			theTribe = (ArrayList<Tavunu>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ois.close();
	}
	
	public static void quit() {
		exitLoop = true;
	}
	
	public static void displayMenu() {
		System.out.println("[a] Add a memeber");
		System.out.println("[r] Remove a member");
		System.out.println("[d] Display the tribe");
		System.out.println("[s] Save the tribe");
		System.out.println("[o] Open the tribe");
		System.out.println("[q] Quit");
		System.out.println("\nWhat would you like to do?");
	}
}
