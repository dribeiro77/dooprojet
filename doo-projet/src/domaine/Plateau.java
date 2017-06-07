package domaine;

public abstract class Plateau {
	private Case[] plateau;
	
	public Plateau(){
	}
	
	public void print(){
		for(int i=0; i<=121 ; i++){
			System.out.println(plateau[i].getId());
		}
	}

	public Case[] getPlateau() {
		return plateau;
	}

	public void setPlateau(Case[] plateau) {
		this.plateau = plateau;
	}
	
	

}
