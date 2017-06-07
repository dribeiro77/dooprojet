package domaine;

public class Case {
	private Pion pion;
	private int id;
	private Case haut_droite;
	private Case haut_gauche;
	private Case bas_gauche;
	private Case bas_droite;
	private Case droite;
	private Case gauche;
	
	public Case(int num){
		id=num;
		pion=null;
		haut_droite=null;
		haut_gauche=null;
		bas_droite=null;
		bas_gauche=null;
		droite=null;
		gauche=null;
	}

	public Pion getPion() {
		return pion;
	}

	public void setPion(Pion pion) {
		this.pion = pion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Case getHaut_droite() {
		return haut_droite;
	}

	public void setHaut_droite(Case haut_droite) {
		this.haut_droite = haut_droite;
	}

	public Case getHaut_gauche() {
		return haut_gauche;
	}

	public void setHaut_gauche(Case haut_gauche) {
		this.haut_gauche = haut_gauche;
	}

	public Case getBas_gauche() {
		return bas_gauche;
	}

	public void setBas_gauche(Case bas_gauche) {
		this.bas_gauche = bas_gauche;
	}

	public Case getBas_droite() {
		return bas_droite;
	}

	public void setBas_droite(Case bas_droite) {
		this.bas_droite = bas_droite;
	}

	public Case getDroite() {
		return droite;
	}

	public void setDroite(Case droite) {
		this.droite = droite;
	}

	public Case getGauche() {
		return gauche;
	}

	public void setGauche(Case gauche) {
		this.gauche = gauche;
	}
	
	

}
