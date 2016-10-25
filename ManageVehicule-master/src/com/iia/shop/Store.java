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
		
		System.out.println("1 - voir tous les véhicules");
		
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
			
		default:
			break;
		}
	
	}

	private static ArrayList<Vehicule> readAll() {
		return vehicules;
	}

	private static void displayVehicule(Vehicule vehicule) {
		System.out.println("Marque : " + vehicule.getMarque());
		System.out.println("Modèle : " + vehicule.getModel());
		System.out.println("Couleur : " + vehicule.getColor());
		System.out.println("Année : " + vehicule.getYear());
		System.out.println("Vitesse : " + vehicule.getSpeed());
		System.out.println("Prix : " + vehicule.getPrice());
		System.out.println("");
	}
	
	private static void assets() {
		
	}
}
