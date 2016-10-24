package com.iia.shop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import com.iia.shop.entity.Vehicule;
import com.iia.shop.entity.VehiculeDao;

public class Menu extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	
	private JButton creer;
	private JButton voir;
	private JButton modif;
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{150, 89, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		creer = new JButton("Cr\u00E9er un V\u00E9hicule");
		GridBagConstraints gbc_creer = new GridBagConstraints();
		gbc_creer.insets = new Insets(0, 0, 5, 0);
		gbc_creer.gridx = 1;
		gbc_creer.gridy = 2;
		panel_1.add(creer, gbc_creer);
		
		voir = new JButton("Voir un V\u00E9hicule");
		GridBagConstraints gbc_voir = new GridBagConstraints();
		gbc_voir.insets = new Insets(0, 0, 5, 0);
		gbc_voir.gridx = 1;
		gbc_voir.gridy = 3;
		panel_1.add(voir, gbc_voir);
		
		modif = new JButton("Modifier un V\u00E9hicule");
		GridBagConstraints gbc_modif = new GridBagConstraints();
		gbc_modif.gridx = 1;
		gbc_modif.gridy = 4;
		panel_1.add(modif, gbc_modif);
		
		this.creer.addActionListener(this);
		this.voir.addActionListener(this);
		this.modif.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.creer) {
			CreerVehicule creer = new CreerVehicule();
			creer.setVisible(true);
		}else if (e.getSource() == this.voir) {
			VoirVéhicule voir = new VoirVéhicule();
			voir.setVisible(true);
		}else if (e.getSource() == this.modif) {
			ModifVehicule modif = new ModifVehicule();
			modif.setVisible(true);
		}
	}

}
