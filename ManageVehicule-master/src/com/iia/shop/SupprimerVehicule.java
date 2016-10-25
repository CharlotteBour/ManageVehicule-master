package com.iia.shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iia.shop.entity.Vehicule;
import com.iia.shop.entity.VehiculeDao;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SupprimerVehicule extends JFrame implements ActionListener {
	private static ArrayList<Vehicule> vehicules;
	private JPanel contentPane;
	private JButton btnSupprimer;
	private JButton btnAnnuler;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerVehicule frame = new SupprimerVehicule();
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
	public SupprimerVehicule() {
		
		vehicules = new ArrayList<Vehicule>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		//gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		VehiculeDao vDao = new VehiculeDao();
		vehicules = (ArrayList<Vehicule>) vDao.findAll();
		
		for (Vehicule vehicule : vehicules) {
			
			comboBox.addItem(vehicule.getId()); // + " - " + vehicule.getModel() + " - " + vehicule.getMarque()
			
			
		}

		btnSupprimer = new JButton("Supprimer");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnSupprimer, gbc_btnNewButton);

		btnAnnuler = new JButton("Annuler");
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.gridx = 2;
		gbc_btnAnnuler.gridy = 4;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);

		this.btnSupprimer.addActionListener(this);
		this.btnAnnuler.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnSupprimer) {
			int res = JOptionPane.showConfirmDialog(null, "Voulez vous Supprimer ?", "Supprimer",
					JOptionPane.YES_NO_OPTION);
			if (res == 0) { // oui
				
				VehiculeDao vDao = new VehiculeDao();
				Vehicule vehicule;
				vehicule = new Vehicule();
				
				int i = (int) comboBox.getSelectedItem();
				vehicule = vDao.findById(i);
				vDao.delete(vehicule);
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

}

