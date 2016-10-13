package com.iia.shop;
import com.iia.shop.entity.VehiculeDao.java;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.iia.shop.entity.Vehicule;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;

public class Store {

	private static ArrayList<Vehicule> vehicules;
	private static Scanner sc;

	public static void main(String[] args) {
		vehicules = new ArrayList<Vehicule>();
		
		assets();
		
		System.out.println("Gestion des v�hicules");
		System.out.println("1 - cr�er un v�hicule");
		System.out.println("2 - mettre � jour un v�hicule");
		System.out.println("3 - voir tous les v�hicules");
		System.out.println("4 - s�lectionner un v�hicule");
		System.out.println("5 - supprimer un v�hicule");
		
		sc = new Scanner(System.in);
		
		System.out.println("Votre choix");
		int choice = sc.nextInt();
		
		Vehicule vehicule;
		
		switch (choice) {
		case 1:
			vehicule = new Vehicule();
			
			setVehicule(vehicule);
			create(vehicule);
			VehiculeDao.create(vehicule);
			break;
		case 2:
			System.out.println("Veuillez saisir l'id du v�hicule");
			vehicule = read(sc.nextInt());
			
			displayVehicule(vehicule);
			setVehicule(vehicule);
			update(vehicule);
			break;
		case 3:
			ArrayList<Vehicule> vehicules = readAll();
			
			for (Vehicule vehicule2 : vehicules) {
				displayVehicule(vehicule2);
			}
			break;
			
		case 4:
			System.out.println("Veuillez saisir l'id du v�hicule");
			vehicule = read(sc.nextInt());
			
			displayVehicule(vehicule);
			
			break;
			
		case 5:
			System.out.println("Veuillez saisir l'id du v�hicule");
			delete(sc.nextInt());
			VehiculeDao.delete(vehicule);
			break;
		default:
			break;
		}

		File serialFile = new File("C:\\Users\\cbour\\cars.txt");

		Store.saveObject(serialFile, vehicules);
		readObject(serialFile); 
		
	}

	public static void saveObject(File file, ArrayList<Vehicule> al) {

		try {
			FileOutputStream out = new FileOutputStream(file, true);
			ObjectOutputStream objectOutput = new ObjectOutputStream(out);

			objectOutput.writeObject(al);
			objectOutput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void readObject(File file) {

		try {
			FileInputStream in;
			in = new FileInputStream(file);
			ObjectInputStream objectIn = new ObjectInputStream(in);
			//Vehicule v = (Vehicule) objectIn.readObject();
			ArrayList<Vehicule> al = (ArrayList)objectIn.readObject();

			for(Vehicule o: al) {
				// Vehicule vSelect =  al.get(i);
			System.out.println(o.toString());
			

			}
		    
			objectIn.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	private static void create(Vehicule vehicule) {
		vehicules.add(vehicule);
		
		
	}

	private static void delete(int index) {
		vehicules.remove(index);
		
	}

	private static ArrayList<Vehicule> readAll() {
		return vehicules;
	}

	private static Vehicule read(int index) {
		return vehicules.get(index);
	}

	private static void displayVehicule(Vehicule vehicule) {
		System.out.println("Marque : " + vehicule.getMarque());
		System.out.println("Mod�le : " + vehicule.getModel());
		System.out.println("Couleur : " + vehicule.getColor());
		System.out.println("Ann�e : " + vehicule.getYear());
		System.out.println("Vitesse : " + vehicule.getSpeed());
		System.out.println("Prix : " + vehicule.getPrice());
	}
	
	private static void setVehicule(Vehicule vehicule) {
		System.out.println("Veuillez saisir la marque du v�hicule");
		vehicule.setMarque(sc.next());
		
		System.out.println("Veuillez saisir l'ann�e du v�hicule");
		vehicule.setYear(sc.nextInt());
		
		System.out.println("Veuillez saisir le mod�le du v�hicule");
		vehicule.setModel(sc.next());
		
		System.out.println("Veuillez saisir la couleur du v�hicule");
		vehicule.setColor(sc.next());

		System.out.println("Veuillez saisir le prix du v�hicule");
		vehicule.setPrice(sc.nextDouble());
	}
	
	private static void assets() {
		
	}
}
