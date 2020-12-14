import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Menu {
	public static String name;
	public static int year;
	public static int pava;
	public static Tavunu t = null;
	public static Tavunu t2 = null;
	private static File f1;
	private static boolean opened = false;
	private static boolean saved = false;
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Menu");
		
		frame.setSize(400, 300);
		frame.setTitle("Tavunu Manager");
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");
		
		menubar.add(file);
		menubar.add(help);
		
		JMenuItem open = new JMenuItem("Open");
		JMenuItem saveAs = new JMenuItem("Save As...");
		JMenuItem new1 = new JMenuItem("New");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem about = new JMenuItem("About");
		
		file.add(open);
		file.add(new1);
		file.add(saveAs);
		file.add(exit);
		help.add(about);
		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		
		class exitaction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		
		class openaction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					panel.removeAll();
					open();
					if(opened == true) {
						JLabel nameLabel = new JLabel("Name: "+t2.getName());
						JLabel rankLabel = new JLabel("Social rank: "+t2.getClass().getName());
						JLabel yearLabel = new JLabel("Birth year: "+t2.getBirthYear());
						JLabel pavaLabel = new JLabel("Pava count: "+t2.getPava());
						panel.setLayout(new GridLayout(4, 0));
						panel.add(nameLabel);
						panel.add(rankLabel);
						panel.add(yearLabel);
						panel.add(pavaLabel);
						JLabel loaded = new JLabel("Tavunu loaded.");
						panel.add(loaded);
						SwingUtilities.updateComponentTreeUI(frame);
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		class saveaction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(t!=null) {
					try {
						save();
						if(saved == true) {
							JLabel saved = new JLabel("Tavunu saved.");
							panel.add(saved);
							SwingUtilities.updateComponentTreeUI(frame);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					panel.removeAll();
					JLabel error = new JLabel("Tavunu not yet created");
					panel.add(error);
					SwingUtilities.updateComponentTreeUI(frame);
				}
			}
		}
		
		class aboutaction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "This is a program that can create, save, and open Tavunu objects."+"\nCreated by Neil Haggerty");
			}
		}
		
		class newaction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				JLabel label = new JLabel("Enter name of Tavunu: ");
				JTextField field1 = new JTextField(20);
				panel.add(label);
				panel.add(field1);
				SwingUtilities.updateComponentTreeUI(frame);
				
				field1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						name = field1.getText();
						panel.remove(field1);
						panel.remove(label);
						SwingUtilities.updateComponentTreeUI(frame);
						JLabel label2 = new JLabel("Enter birth year: ");
						JTextField field2 = new JTextField(20);
						panel.add(label2);
						panel.add(field2);
						SwingUtilities.updateComponentTreeUI(frame);
						
						field2.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e) {
								year = Integer.parseInt(field2.getText());
								panel.remove(field2);
								panel.remove(label2);
								SwingUtilities.updateComponentTreeUI(frame);
								JLabel label3 = new JLabel("Enter pava count: ");
								JTextField field3 = new JTextField(20);
								panel.add(label3);
								panel.add(field3);
								SwingUtilities.updateComponentTreeUI(frame);
								
								field3.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e) {
										pava = Integer.parseInt(field3.getText());
										panel.remove(field3);
										panel.remove(label3);
										SwingUtilities.updateComponentTreeUI(frame);
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
										JLabel nameLabel = new JLabel("Name: "+t.getName());
										JLabel rankLabel = new JLabel("Social rank: "+t.getClass().getName());
										JLabel yearLabel = new JLabel("Birth year: "+t.getBirthYear());
										JLabel pavaLabel = new JLabel("Pava count: "+t.getPava());
										
										panel.setLayout(new GridLayout(5, 0));
										panel.add(nameLabel);
										panel.add(rankLabel);
										panel.add(yearLabel);
										panel.add(pavaLabel);
										SwingUtilities.updateComponentTreeUI(frame);
									}
								});
							}
						});
					}
				});
			}
		}
		
		
		exit.addActionListener(new exitaction());
		open.addActionListener(new openaction());
		saveAs.addActionListener(new saveaction());
		new1.addActionListener(new newaction());
		about.addActionListener(new aboutaction());
	}
	public static void save() throws IOException {
		JFileChooser chooser = new JFileChooser(".");
		int response;
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		response = chooser.showSaveDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {
			f1 = chooser.getSelectedFile();
		}
		if(f1 == null) {
			
		} else {
			saved = true;
			try {

			    //Write Student array to file.
			    FileOutputStream fos = new FileOutputStream(f1);
			    ObjectOutputStream oos = new ObjectOutputStream(fos);
			    oos.writeObject(t);
			    oos.close();

			    
			}
			catch (FileNotFoundException e) {
			    e.printStackTrace();
			}
			catch (IOException e) {
			    e.printStackTrace();
			}
		}
		
		
	}
	public static void open() throws IOException {
		JFileChooser chooser = new JFileChooser(".");
		int response;
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		response = chooser.showOpenDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {
			f1 = chooser.getSelectedFile();			
		}
		
		
		if(f1==null) {
			
		} else {
			opened = true;
			FileInputStream fis = new FileInputStream(f1);
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    try {
				t2 = (Tavunu) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    ois.close();
		}
	    
	}
}
