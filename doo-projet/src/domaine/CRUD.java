package domaine;
import java.sql.*;


public class CRUD implements DALJoueur{
	
	// JDBC driver et BD URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/JEUX";

	   //  BD 
	   static final String USER = "IATIC3";
	   static final String PASS = "12345";

	  private Connection conn = null;
	  private Statement stmt = null;
	   
	@Override
	public void connection() throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub

		      /*JDBC driver */
		      Class.forName("com.mysql.jdbc.Driver");

		      /*Ouvrir une connection */
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      System.out.println("Connection à la BD ...");

		   
	}

	@Override
	public boolean ajouter_Joueur(Joueur j) throws SQLException{
		// TODO Auto-generated method stub
	
		if(existance_joueur(j.getPseudo())== 0)
		{stmt = conn.createStatement();
		stmt.executeUpdate( "INSERT INTO JOUEUR (Login) VALUES ('"+j.getPseudo()+"');");
		return true;
		}
		else 
		return false;
	}

	@Override
	public void deconnexion() throws SQLException {
		// TODO Auto-generated method stub
			stmt.close();	
			conn.close();
	}

	
	@Override
	public boolean supprimer_joueur(Joueur j ) throws SQLException {
		if(existance_joueur(j.getPseudo())!= 0)
		{
		
		stmt = conn.createStatement();
		stmt.executeUpdate( "DELETE FROM JOUEUR WHERE Login ='"+j.getPseudo()+"'");
		return true;
		
		}
		else
			return false;
	}

	@Override
	public ResultSet lister_joueur() throws SQLException {
		// TODO Auto-generated method stub
		
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT Login, Score , Score2  FROM JOUEUR ORDER BY Score,Score2 ";
	      ResultSet rs = stmt.executeQuery(sql);
	      return rs;
	}

	@Override
	public ResultSet lister_joueur_abalone() throws SQLException {
		// TODO Auto-generated method stub
		  stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT Login, Score  FROM JOUEUR WHERE Score > 0 ORDER BY Score ";
	      ResultSet rs = stmt.executeQuery(sql);

	     
		return rs;
	}

	@Override
	public ResultSet lister_joueur_dames_chinoise() throws SQLException {
		// TODO Auto-generated method stub
		  stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT Login,Score2  FROM JOUEUR WHERE Score2 >0 ORDER BY Score2 ";
	      ResultSet rs = stmt.executeQuery(sql);

	     
		return rs;
	}

	@Override
	public void afficher(ResultSet res) throws SQLException {
		// TODO Auto-generated method stub
		while(res.next()){ 
			String login = res.getString(1); 
			int score = res.getInt(2);
			int score2 = res.getInt(3);
			System.out.println(" login : "+login+ " score : "+score+" score2 : "+score2); 
		
	}

	}

	@Override
	public int existance_joueur(String login) throws SQLException {
		// TODO Auto-generated method stub
			
			int id=0;
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT Id FROM JOUEUR WHERE Login ='"+login+"'";
			
			ResultSet res = stmt.executeQuery(sql);
			
			while(res.next())
				{
				id= res.getInt("Id");
				}
		return id;
	}

	@Override
	public boolean scoreAbalone(Joueur j, int res) throws SQLException {
		// TODO Auto-generated method stub
		int id ;
		id = existance_joueur(j.getPseudo());
		if(id !=0)
		{stmt = conn.createStatement();
		stmt.executeUpdate( "UPDATE JOUEUR SET Score = '"+res+"' WHERE Id = '"+id+"' ;");
		return true;
		}
		else 
		return false;
		
	}

	@Override
	public boolean scoreDameChinoise(Joueur j, int res) throws SQLException {
		// TODO Auto-generated method stub
		int id ;
		id = existance_joueur(j.getPseudo());
		if(id !=0)
		{stmt = conn.createStatement();
		stmt.executeUpdate( "UPDATE JOUEUR SET Score2 = '"+res+"' WHERE Id = '"+id+"' ;");
		return true;
		}
		else 
		return false;
				
	}

	@Override
	public int ancienscoreAbalone(Joueur j) throws SQLException {
		// TODO Auto-generated method stub
		
		int id ;
		id = existance_joueur(j.getPseudo());
		if(id !=0)
			
		stmt = conn.createStatement();
	    String sql;
	    sql = "SELECT Score FROM JOUEUR  WHERE Id = '"+id+"' ;";
	    ResultSet rs = stmt.executeQuery(sql);
		rs.next();
	    return rs.getInt(1);
	}

	@Override
	public int ancienScoreDameChinoise(Joueur j) throws SQLException {
		// TODO Auto-generated method stub
		
		int id ;
		id = existance_joueur(j.getPseudo());
		if(id !=0)
		
		stmt = conn.createStatement();
	    String sql;
	    sql = "SELECT Score2 FROM JOUEUR  WHERE Id = '"+id+"' ;";
	    ResultSet rs = stmt.executeQuery(sql);
		rs.next();
			
		return rs.getInt(1);
	}

	
}	