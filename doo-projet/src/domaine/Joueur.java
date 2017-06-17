package domaine;

public class Joueur {
	private String pseudo;
	private int score;
	
	public Joueur(String p){
		pseudo=p;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int sc){
		score += sc;
	}
	
	

}
