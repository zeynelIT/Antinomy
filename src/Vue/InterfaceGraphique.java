package Vue;
/*
 * Sokoban - Encore une nouvelle version (à but pédagogique) du célèbre jeu
 * Copyright (C) 2018 Guillaume Huard
 *
 * Ce programme est libre, vous pouvez le redistribuer et/ou le
 * modifier selon les termes de la Licence Publique Générale GNU publiée par la
 * Free Software Foundation (version 2 ou bien toute autre version ultérieure
 * choisie par vous).
 *
 * Ce programme est distribué car potentiellement utile, mais SANS
 * AUCUNE GARANTIE, ni explicite ni implicite, y compris les garanties de
 * commercialisation ou d'adaptation dans un but spécifique. Reportez-vous à la
 * Licence Publique Générale GNU pour plus de détails.
 *
 * Vous devez avoir reçu une copie de la Licence Publique Générale
 * GNU en même temps que ce programme ; si ce n'est pas le cas, écrivez à la Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307,
 * États-Unis.
 *
 * Contact:
 *          Guillaume.Huard@imag.fr
 *          Laboratoire LIG
 *          700 avenue centrale
 *          Domaine universitaire
 *          38401 Saint Martin d'Hères
 */

import Modele.Jeu;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// L'interface runnable déclare une méthode run
public class InterfaceGraphique implements Runnable, InterfaceUtilisateur {
	Jeu j;
	CollecteurEvenements control;
	JFrame menuPrincipale;
	JFrame enJeu;
	boolean maximized;
	NiveauGraphique niv;

	JFrame courant;

	static Font h1;
	static Font h2 = new Font("TimesRoman", Font.PLAIN, 15);

	InterfaceGraphique(Jeu jeu, CollecteurEvenements c) {
		j = jeu;
		control = c;
	}

	public static void demarrer(Jeu j, CollecteurEvenements c) {
		InterfaceGraphique vue = new InterfaceGraphique(j, c);
		c.ajouteInterfaceUtilisateur(vue);
		SwingUtilities.invokeLater(vue);
	}

	public void toggleFullscreen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		if (maximized) {
			device.setFullScreenWindow(null);
			maximized = false;
		} else {
			device.setFullScreenWindow(courant);
			maximized = true;
		}
	}

	public void run() {
		menuPrincipale = new JFrame("Antinomy");
		enJeu = new JFrame("Antinomy");

		niv = new NiveauGraphique(j);
		niv.addMouseListener(new AdaptateurSouris(niv, control));

//		menuPrincipale.addKeyListener(new AdaptateurClavier(control));
		enJeu.addKeyListener(new AdaptateurClavier(control));

		setMenuPrincipale();

		h1 = new Font("TimesRoman", Font.PLAIN, menuPrincipale.getWidth()/2);

		Timer chrono = new Timer(16, new AdaptateurTemps(control));
		chrono.start();

		enJeu.add(niv);

		enJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enJeu.setSize(500, 300);
		menuPrincipale.setVisible(false);
		menuPrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipale.setSize(500, 300);
		enJeu.setVisible(true);
		courant = enJeu;
	}

	void setMenuPrincipale(){
		Box menu = Box.createVerticalBox();

		menu.add(Box.createGlue());

		JLabel nom_jeu = new JLabel("Antinomy");

		nom_jeu.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		menu.add(nom_jeu);

		//=================
		menu.add(Box.createGlue());

		JButton nouvelle_partie = new JButton("Nouvelle Partie");
		ActionListener nouvelle_partie_action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};
		nouvelle_partie.setAlignmentX(JButton.CENTER_ALIGNMENT);
		nouvelle_partie.addActionListener(nouvelle_partie_action);

		menu.add(nouvelle_partie);

		//=================
		menu.add(Box.createGlue());

		JButton charger = new JButton("Charger");
		ActionListener charger_action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};
		charger.setAlignmentX(JButton.CENTER_ALIGNMENT);
		charger.addActionListener(charger_action);

		menu.add(charger);

		//=================
		menu.add(Box.createGlue());

		JButton tutoriel = new JButton("Tutoriel");
		ActionListener tutoriel_action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};
		tutoriel.setAlignmentX(JButton.CENTER_ALIGNMENT);
		tutoriel.addActionListener(tutoriel_action);

		menu.add(tutoriel);

		//=================
		menu.add(Box.createGlue());

		JButton options = new JButton("Options");
		ActionListener options_action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};
		options.setAlignmentX(JButton.CENTER_ALIGNMENT);
		options.addActionListener(options_action);

		menu.add(options);

		//=================

		menu.add(Box.createGlue());

		menuPrincipale.add(menu);
	}

	public void decale(int l, int c, double dl, double dc) {
//		niv.decale(l, c, dl, dc);
	}


	public void metAJourDirection(int dL, int dC) {

//		niv.metAJourDirection(dL, dC);
	}

	public void changeEtape() {
//		niv.changeEtape();
	}
}
