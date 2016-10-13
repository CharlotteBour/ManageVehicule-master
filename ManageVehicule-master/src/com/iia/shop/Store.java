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
		
		System.out.println("Gestion des véhicules");
		System.out.println("1 - créer un véhicule");
		System.out.println("2 - mettre à jour un véhicule");
		System.out.println("3 - voir tous les véhicules");
		System.out.println("4 - sélectionner un véhicule");
		System.out.println("5 - supprimer un véhicule");
		
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
			System.out.println("Veuillez saisir l'id du véhicule");
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
			System.out.println("Veuillez saisir l'id du véhicule");
			vehicule = read(sc.nextInt());
			
			displayVehicule(vehicule);
			
			break;
			
		case 5:
			System.out.println("Veuillez saisir l'id du véhicule");
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
		System.out.println("Modèle : " + vehicule.getModel());
		System.out.println("Couleur : " + vehicule.getColor());
		System.out.println("Année : " + vehicule.getYear());
		System.out.println("Vitesse : " + vehicule.getSpeed());
		System.out.println("Prix : " + vehicule.getPrice());
	}
	
	private static void setVehicule(Vehicule vehicule) {
		System.out.println("Veuillez saisir la marque du véhicule");
		vehicule.setMarque(sc.next());
		
		System.out.println("Veuillez saisir l'année du véhicule");
		vehicule.setYear(sc.nextInt());
		
		System.out.println("Veuillez saisir le modèle du véhicule");
		vehicule.setModel(sc.next());
		
		System.out.println("Veuillez saisir la couleur du véhicule");
		vehicule.setColor(sc.next());

		System.out.println("Veuillez saisir le prix du véhicule");
		vehicule.setPrice(sc.nextDouble());
	}
	
	private static void assets() {
		
	}
}
