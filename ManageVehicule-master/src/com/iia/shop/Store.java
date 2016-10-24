package com.iia.shop;
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
import com.iia.shop.entity.VehiculeDao;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;

public class Store {

	private static ArrayList<Vehicule> vehicules;
	private static Scanner sc;

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setVisible(true);
		
		vehicules = new ArrayList<Vehicule>();
		
		assets();
		
		System.out.println("Gestion des v�hicules");
		System.out.println("1 - voir tous les v�hicules");
		System.out.println("2 - supprimer un v�hicule");
		
		sc = new Scanner(System.in);
		
		System.out.println("Votre choix");
		int choice = sc.nextInt();
		
		VehiculeDao vdao = new VehiculeDao();
		Vehicule vehicule;
		
		switch (choice) {
		
		case 1:
			vehicules = (ArrayList<Vehicule>) vdao.findAll();
			
			for (Vehicule vehicule2 : vehicules) {
				displayVehicule(vehicule2);
			}
			break;
			
		case 2:
			System.out.println("Veuillez saisir l'id du v�hicule");
			
			vehicule = new Vehicule();
			vehicule.setId(sc.nextInt());
			vdao.delete(vehicule);
			break;
		default:
			break;
		}
	
	}

	private static void delete(int index) {
		vehicules.remove(index);
		
	}

	private static ArrayList<Vehicule> readAll() {
		return vehicules;
	}

	private static void displayVehicule(Vehicule vehicule) {
		System.out.println("Marque : " + vehicule.getMarque());
		System.out.println("Mod�le : " + vehicule.getModel());
		System.out.println("Couleur : " + vehicule.getColor());
		System.out.println("Ann�e : " + vehicule.getYear());
		System.out.println("Vitesse : " + vehicule.getSpeed());
		System.out.println("Prix : " + vehicule.getPrice());
		System.out.println("");
	}
	
	 static void setVehicule(Vehicule vehicule) {
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
		
		System.out.println("Veuillez saisir la vitesse du v�hicule");
		vehicule.setSpeed(sc.nextInt());
	}
	
	private static void assets() {
		
	}
}
