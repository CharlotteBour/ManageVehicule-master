package com.iia.shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.iia.shop.entity.Vehicule;
import com.iia.shop.entity.VehiculeDao;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ModifVehicule extends JFrame implements ActionListener {
	private static ArrayList<Vehicule> vehicules;
	private JPanel contentPane;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JTextField tfMarque;
	private JTextField tfAnnee;
	private JTextField tfModele;
	private JTextField tfCouleur;
	private JTextField tfPrix;
	private JTextField tfVitesse;
	private JLabel lblMarque;
	private JLabel lblAnnee;
	private JLabel lblModele;
	private JLabel lblCouleur;
	private JLabel lblPrix;
	private JLabel lblVitesse;
	private JTextField textField;
	private JLabel lblNumroDeLa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifVehicule frame = new ModifVehicule();
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
	public ModifVehicule() {
		vehicules = new ArrayList<Vehicule>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblNumroDeLa = new JLabel("Num\u00E9ro de la voiture a modifier");
		GridBagConstraints gbc_lblNumroDeLa = new GridBagConstraints();
		gbc_lblNumroDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeLa.gridx = 1;
		gbc_lblNumroDeLa.gridy = 0;
		contentPane.add(lblNumroDeLa, gbc_lblNumroDeLa);

		textField = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 0;
		contentPane.add(textField, gbc_textField_7);
		textField.setColumns(10);

		lblAnnee = new JLabel("Annee");
		GridBagConstraints gbc_lblAnnee = new GridBagConstraints();
		gbc_lblAnnee.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnnee.gridx = 1;
		gbc_lblAnnee.gridy = 2;
		contentPane.add(lblAnnee, gbc_lblAnnee);

		tfAnnee = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		contentPane.add(tfAnnee, gbc_textField_1);
		tfAnnee.setColumns(10);

		lblModele = new JLabel("Modele");
		GridBagConstraints gbc_lblModele = new GridBagConstraints();
		gbc_lblModele.insets = new Insets(0, 0, 5, 5);
		gbc_lblModele.gridx = 1;
		gbc_lblModele.gridy = 3;
		contentPane.add(lblModele, gbc_lblModele);

		tfModele = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 3;
		contentPane.add(tfModele, gbc_textField_2);
		tfModele.setColumns(10);

		lblCouleur = new JLabel("Couleur");
		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleur.gridx = 1;
		gbc_lblCouleur.gridy = 4;
		contentPane.add(lblCouleur, gbc_lblCouleur);

		tfCouleur = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 4;
		contentPane.add(tfCouleur, gbc_textField_3);
		tfCouleur.setColumns(10);

		lblPrix = new JLabel("Prix");
		GridBagConstraints gbc_lblPrix = new GridBagConstraints();
		gbc_lblPrix.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrix.gridx = 1;
		gbc_lblPrix.gridy = 5;
		contentPane.add(lblPrix, gbc_lblPrix);

		tfPrix = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 5;
		contentPane.add(tfPrix, gbc_textField_4);
		tfPrix.setColumns(10);

		lblVitesse = new JLabel("Vitesse");
		GridBagConstraints gbc_lblVitesse = new GridBagConstraints();
		gbc_lblVitesse.insets = new Insets(0, 0, 5, 5);
		gbc_lblVitesse.gridx = 1;
		gbc_lblVitesse.gridy = 6;
		contentPane.add(lblVitesse, gbc_lblVitesse);

		tfVitesse = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 6;
		contentPane.add(tfVitesse, gbc_textField_5);
		tfVitesse.setColumns(10);

		lblMarque = new JLabel("Marque");
		GridBagConstraints gbc_lblMarque = new GridBagConstraints();
		gbc_lblMarque.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarque.gridx = 1;
		gbc_lblMarque.gridy = 7;
		contentPane.add(lblMarque, gbc_lblMarque);

		tfMarque = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 7;
		contentPane.add(tfMarque, gbc_textField_6);
		tfMarque.setColumns(10);

		this.tfMarque.addActionListener(this);

		btnValider = new JButton("Valider");
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 0, 5);
		gbc_btnValider.gridx = 1;
		gbc_btnValider.gridy = 8;
		contentPane.add(btnValider, gbc_btnValider);

		btnAnnuler = new JButton("Annuler");
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.gridx = 2;
		gbc_btnAnnuler.gridy = 8;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);

		this.textField.addActionListener(this);
		this.tfAnnee.addActionListener(this);
		this.tfModele.addActionListener(this);
		this.tfCouleur.addActionListener(this);
		this.tfPrix.addActionListener(this);
		this.tfVitesse.addActionListener(this);
		this.btnValider.addActionListener(this);
		this.btnAnnuler.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.btnValider) {
			int res = JOptionPane.showConfirmDialog(null, "Voulez vous valider ?", "valider",
					JOptionPane.YES_NO_OPTION);
			if (res == 0) { // oui
				VehiculeDao vDao = new VehiculeDao();
				Vehicule vehicule;
				vehicule = new Vehicule();
				int i = Integer.parseInt(textField.getText());
				vehicule.setId(i);
				modifier(vehicule);
				vDao.update(vehicule);
				this.dispose();
			}

		} else if (e.getSource() == this.btnAnnuler) {
			int res = JOptionPane.showConfirmDialog(null, "Voulez vous annuler ?", "annuler",
					JOptionPane.YES_NO_OPTION);
			if (res == 0) { // oui
				this.dispose();
			}
		}

	}
	
	public void modifier(Vehicule vehicule) {
		int res = 0;
		vehicule.setMarque(tfMarque.getText());
		res = Integer.parseInt(tfAnnee.getText());
		vehicule.setYear(res);
		vehicule.setModel(tfModele.getText());
		vehicule.setColor(tfCouleur.getText());
		res = Integer.parseInt(tfPrix.getText());
		vehicule.setPrice(res);
		res = Integer.parseInt(tfVitesse.getText());
		vehicule.setSpeed(res);
		vehicules.add(vehicule);
	}

}
