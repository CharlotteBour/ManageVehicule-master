package com.iia.shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iia.shop.entity.Vehicule;
import com.iia.shop.entity.VehiculeDao;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;

public class VoirToutVehicules extends JFrame implements ActionListener{
	private static ArrayList<Vehicule> vehicules;
	private JPanel contentPane;
	private JButton quitter;
	private ArrayList<JLabel> lId;
	private ArrayList<JLabel> lMarque;
	private ArrayList<JLabel> lModele;
	private ArrayList<JLabel> lprix ;
	private ArrayList<JLabel> lannee ;
	private ArrayList<JLabel> lcouleur;
	private ArrayList<JLabel> lVitesse ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoirToutVehicules frame = new VoirToutVehicules();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VoirToutVehicules() {
		vehicules = new ArrayList<Vehicule>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		VehiculeDao vdao = new VehiculeDao();
		vehicules = (ArrayList<Vehicule>) vdao.findAll();

		lId = new ArrayList<JLabel>();
		lMarque = new ArrayList<JLabel>();
		lModele = new ArrayList<JLabel>();
		lprix = new ArrayList<JLabel>();
		lannee = new ArrayList<JLabel>();
		lcouleur = new ArrayList<JLabel>();
		lVitesse = new ArrayList<JLabel>();
		
		JLabel id;
		JLabel marque;
		JLabel model;
		JLabel price;
		JLabel year;
		JLabel color;
		JLabel speed;
		
		//A finir !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		for (Vehicule vehicule : vehicules) {
			
			System.out.println("marche");
			
			id = new JLabel();
			marque = new JLabel();
			model = new JLabel();
			price = new JLabel();
			year = new JLabel();
			color = new JLabel();
			speed = new JLabel();
			
			id.setText("Identifiant : " + vehicule.getId());
			marque.setText("Modele : " + vehicule.getMarque());
			model.setText("Modele : " + vehicule.getModel());
			price.setText(" Prix : " + vehicule.getPrice());
			year.setText(" Annee : " + vehicule.getYear());
			color.setText("Couleur : " + vehicule.getColor());
			speed.setText(" Vitesse : " + vehicule.getSpeed());
			
			lId.add(id);
			lMarque.add(marque);
			lModele.add(model);
			lprix.add(price);
			lannee.add(year);
			lcouleur.add(color);
			lVitesse.add(speed);
			
		//	lId.add(new JLabel("Identifiant : " + vehicule.getId()));
		//	lMarque.add(new JLabel("Modele : " + vehicule.getModel()));
		//	lModele.add(new JLabel("Modele : " + vehicule.getModel()));
		//	lprix.add(new JLabel(" Prix : " + vehicule.getPrice()));
		//	lannee.add(new JLabel(" Annee : " + vehicule.getYear()));
		//	lcouleur.add(new JLabel("Couleur : " + vehicule.getColor()));
		//	lVitesse.add(new JLabel(" Vitesse : " + vehicule.getSpeed()));

		}
		
		quitter = new JButton("Quitter");
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.gridx = 6;
		gbc_btnQuitter.gridy = 7;
		contentPane.add(quitter, gbc_btnQuitter);
		
		this.quitter.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.quitter) {
			int res = JOptionPane.showConfirmDialog(null, "Voulez vous quitter ?", "quitter", JOptionPane.YES_NO_OPTION);
			if (res == 0) { //oui
				this.dispose();
			}
		}
		
	}

}
