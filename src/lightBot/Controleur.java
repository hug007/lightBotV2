package lightBot;

import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class Controleur {
	private TiledMap controleur;
	public enum Controleurrobot {haut,gauche,droite,bas,vide;}
	public List<Controleurrobot> listControleurClickUtilisateur = new LinkedList<Controleurrobot>();
	
	
	public Controleur(TiledMap controleur) {
        this.controleur=controleur   v;
    }
	
	public void render() {
		this.controleur.render(50, 550);
		//this.controleur.render(0, 64);
	}

	public void init() throws SlickException {
		this.controleur = new TiledMap("src/main/resources/controleur/controleurLvl1.tmx");
	}
	public void add(int control) {

		switch (control)
		{
		  case 0:
			  listControleurClickUtilisateur.add(Controleurrobot.vide);
		    break;
		  case 1:
			  listControleurClickUtilisateur.add(Controleurrobot.haut);
		    break;
		  case 2:
			  listControleurClickUtilisateur.add(Controleurrobot.gauche);
		    break;
		  case 3:
			  listControleurClickUtilisateur.add(Controleurrobot.droite);
			break;
		  case 4:
			  listControleurClickUtilisateur.add(Controleurrobot.bas);
			 break;
		  default:
			  listControleurClickUtilisateur.add(Controleurrobot.vide);
		}
	}
}
