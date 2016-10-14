package com.iia.shop.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iia.shop.Connexion;


public class VehiculeDao implements IDao<Vehicule>{

	private static final String TABLENAME = "Vehicule";
	private static final String ID = "Identifiant";
	private static final String BRAND = "Marque";
	private static final String YEAR = "Annee";
	private static final String SPEED = "Speed";
	private static final String MODEL = "Model";
	private static final String COLOR = "Color";
	private static final String PRICE = "Price";


	@Override
	public boolean create(Vehicule object) {

String req = "insert into " + VehiculeDao.TABLENAME + " (" + VehiculeDao.BRAND + ", " + VehiculeDao.YEAR 
+ ", " + VehiculeDao.SPEED + ", " + VehiculeDao.MODEL + ", " + VehiculeDao.COLOR + ", " + VehiculeDao.PRICE
+ ") VALUES('" + (object).getMarque()+ "', " + (object).getYear() + ", " + (object).getSpeed() 
+ ", '" + (object).getModel() + "', '" + (object).getColor() + "', " + (object).getPrice()
+ ");" ;

try {
	Statement st = Connexion.getConnection().createStatement();
	if (st.executeUpdate(req) == 1) {
		return true;
	}
} catch (SQLException e) {
	System.out.println("erreur create");
}
		
		return false;
	}

	@Override
	public boolean update(Vehicule object) {
		String req = "UPDATE " + VehiculeDao.TABLENAME +
				" SET " + VehiculeDao.BRAND + "='" + object.getMarque() + "', " + VehiculeDao.YEAR + 
				"= " + object.getYear() + ", " + VehiculeDao.SPEED + 
				"= " + object.getSpeed()  + ", " + VehiculeDao.MODEL + 
				"= '" + object.getModel() + "', " + VehiculeDao.COLOR + 
				"= '" + object.getColor() + "', " + VehiculeDao.PRICE + 
				"= " + object.getPrice()
				+ " WHERE " + VehiculeDao.ID + "=" + object.getId(); 
		try {
			Statement st = Connexion.getConnection().createStatement();
			if(st.executeUpdate(req) >= 1 ) {
				
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur maj");
		}
		return false;
	}

	@Override
	public boolean delete (Vehicule object) {
		
		String req = "DELETE FROM " + VehiculeDao.TABLENAME + " WHERE Identifiant =" + (object).getId();
		try {
			Statement st = Connexion.getConnection().createStatement();
			if (st.executeUpdate(req) >= 1) {
				
				return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Vehicule findById(int id) {

		String req = String.format("select * from %s where %s=%d", VehiculeDao.TABLENAME, VehiculeDao.ID, id);
		try {
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			
			if(rs.next()) {
				Vehicule ve = new Vehicule();
				ve.setId(rs.getInt(VehiculeDao.ID));
				ve.setMarque(rs.getString(VehiculeDao.BRAND));
				ve.setYear(rs.getInt(VehiculeDao.YEAR));
				ve.setSpeed(rs.getInt(VehiculeDao.SPEED));
				ve.setModel(rs.getString(VehiculeDao.MODEL));
				ve.setColor(rs.getString(VehiculeDao.COLOR));
				ve.setPrice(rs.getInt(VehiculeDao.PRICE));
				
			return ve;	
			}
		}catch(SQLException e) {	
		}
		return null;
	}

	@Override
	public List<Vehicule> findAll() {
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		
		String req = String.format("select * from %s", VehiculeDao.TABLENAME);
		
		 try {
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			
			while(rs.next()) {

				vehicules.add(cursorToVehicule(rs));
				
			}
			
			return vehicules;
			
		} catch (SQLException e) {
			System.out.println("Marche pas : recup clients");
		}
		 
		 
		return null;
	}
	
	private Vehicule cursorToVehicule(ResultSet resSet) {
		Vehicule ve = new Vehicule();
		
		try {
			ve = new Vehicule();
			ve.setId(resSet.getInt(VehiculeDao.ID));
			ve.setMarque(resSet.getString(VehiculeDao.BRAND));
			ve.setYear(resSet.getInt(VehiculeDao.YEAR));
			ve.setSpeed(resSet.getInt(VehiculeDao.SPEED));
			ve.setModel(resSet.getString(VehiculeDao.MODEL));
			ve.setColor(resSet.getString(VehiculeDao.COLOR));
			ve.setPrice(resSet.getInt(VehiculeDao.PRICE));
			
			
		} catch (SQLException e) {
			System.out.println("Marche pas ");
		}
	
		
		return ve;
	}

	@Override
	public boolean createV(Vehicule object) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
}
