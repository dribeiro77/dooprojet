package domaine;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DALJoueur {
	
	
	/* Interaction BD */
	public void connection ()throws SQLException, ClassNotFoundException;
	public void deconnexion ()throws SQLException;
	
	
	public int existance_joueur(String login )throws SQLException;
	public boolean ajouter_Joueur(Joueur j)throws SQLException;
	public boolean supprimer_joueur(Joueur j )throws SQLException;
	
	/* Scores des deux jeux */
	
	public ResultSet lister_joueur() throws SQLException;
	public ResultSet lister_joueur_abalone()throws SQLException;
	public ResultSet lister_joueur_dames_chinoise()throws SQLException;
	
	public boolean scoreAbalone(Joueur j , int res) throws SQLException ;
	public boolean scoreDameChinoise(Joueur j , int res) throws SQLException ;

	public void afficher(ResultSet res) throws SQLException;

}
