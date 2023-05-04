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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdaptateurSouris extends MouseAdapter {
	NiveauGraphique n;
	CollecteurEvenements control;

	AdaptateurSouris(NiveauGraphique niv, CollecteurEvenements c) {
		n = niv;
		control = c;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getY() >= n.hauteur - n.hauteurCarte - n.padding && e.getY() <= n.hauteur - n.padding && n.joueurCourant == 0) {
			for (int i = 0; i < 3; i++) {
				if (e.getX() >= n.deb_joueur + i * n.largeurCarte + i * n.padding && e.getX() < n.deb_joueur + (i + 1) * n.largeurCarte + i * n.padding) {
					System.out.println("Joueur0 Clicked : " + i);
					control.clicSouris(1, i);
					return;
				}
			}
		}
		if (e.getY() >= n.padding && e.getY() <= n.padding + n.hauteurCarte && n.joueurCourant == 1) {
			for (int i = 0; i < 3; i++) {
				if (e.getX() >= n.deb_joueur + i * n.largeurCarte + i * n.padding && e.getX() < n.deb_joueur + (i + 1) * n.largeurCarte + i * n.padding) {
					System.out.println("Joueur1 Clicked : " + i);
					control.clicSouris(3, i);
					return;
				}
			}
		}
		if (e.getY() >= n.padding && e.getY() <= n.padding + n.largeurCarte ){
			//bouton
			for (int i = 0; i < 4; i++) {
				if (e.getX() >= n.deb_bouton + i*n.largeurCarte + i*n.padding && e.getX() < n.deb_bouton + (i+1)*n.largeurCarte + i*n.padding){
					System.out.println("Bouton Clicked : " + i);
					control.clicSourisBouton(i);
					return;
				}
			}


		}  else if (e.getY() >= n.centre_hauteur - n.hauteurCarte/2 && e.getY() <= n.centre_hauteur + n.hauteurCarte/2) {
			for (int i = 0; i < 9; i++) {
				if (e.getX() >= n.deb_continuum + i*n.largeurCarte + i*n.padding && e.getX() < n.deb_continuum + (i+1)*n.largeurCarte + i*n.padding){
					System.out.println("Continium Clicked : " + i);
					control.clicSouris(2, i);
					return;
				}
			}
		}
	}
}
