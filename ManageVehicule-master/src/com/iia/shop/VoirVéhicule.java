package com.iia.shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iia.shop.entity.Vehicule;
import com.iia.shop.entity.VehiculeDao;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VoirVéhicule extends JFrame implements ActionListener{
	private static ArrayList<Vehicule> vehicules;
	private JPanel contentPane;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JLabel lblNumroDeLa;
	private JTextField textField;
	private JLabel lMarque;
	private JLabel lModele;
	private JLabel lVitesse;
	private JLabel lprix;
	private JLabel lcouleur;
	private JLabel lannee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoirVéhicule frame = new VoirVéhicule();
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
	public VoirVéhicule() {
		vehicules = new ArrayList<Vehicule>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNumroDeLa = new JLabel("Num\u00E9ro de la voiture");
		GridBagConstraints gbc_lblNumroDeLa = new GridBagConstraints();
		gbc_lblNumroDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeLa.gridx = 1;
		gbc_lblNumroDeLa.gridy = 2;
		contentPane.add(lblNumroDeLa, gbc_lblNumroDeLa);
		
		String[] tab = {"Option 1", "Option 2", "Option 3", "Option 4"};
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		
		btnValider = new JButton("Valider");
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 1;
		gbc_btnValider.gridy = 4;
		contentPane.add(btnValider, gbc_btnValider);
		
		btnAnnuler = new JButton("Annuler");
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 2;
		gbc_btnAnnuler.gridy = 4;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);
		
		lMarque = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 5;
		contentPane.add(lMarque, gbc_label);
		
		lModele = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 6;
		contentPane.add(lModele, gbc_label_1);
		
		lVitesse = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 7;
		contentPane.add(lVitesse, gbc_lblNewLabel);
		
		lprix = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 8;
		contentPane.add(lprix, gbc_label_2);
		
		lcouleur = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 9;
		contentPane.add(lcouleur, gbc_label_3);
		
		lannee = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 10;
		contentPane.add(lannee, gbc_label_4);
		this.btnValider.addActionListener(this);
		this.btnAnnuler.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnValider) {
			int res = JOptionPane.showConfirmDialog(null, "Voulez vous valider ?", "valider", JOptionPane.YES_NO_OPTION);
			if (res == 0) { //oui
				VehiculeDao vDao = new VehiculeDao();
				Vehicule vehicule;
				vehicule = new Vehicule();
				int i = Integer.parseInt(textField.getText());
				vehicule = vDao.findById(i);
				String color = vehicule.getColor();
				String marque = vehicule.getMarque();
				String modele = vehicule.getModel();
				int vitesse = vehicule.getSpeed();
				int year = vehicule.getYear();
				int prix = (int) vehicule.getPrice();
				
				lMarque.setText("Marque : "+ marque);
				lModele.setText("Modele : "+ modele);
				lcouleur.setText("Couleur : " + color);
				lprix.setText(" Prix : "+ prix);
				lVitesse.setText(" Vitesse : " + vitesse);
				lannee.setText(" Annee : "+ year);
			}
			
		}else if (e.getSource() == this.btnAnnuler) {
			int res = JOptionPane.showConfirmDialog(null, "Voulez vous annuler ?", "annuler", JOptionPane.YES_NO_OPTION);
			if (res == 0) { //oui
				this.dispose();
			}
		}
		
	}

}
