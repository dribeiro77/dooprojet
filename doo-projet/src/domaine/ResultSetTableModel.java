
package domaine;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class ResultSetTableModel extends AbstractTableModel {
	
	private ResultSet resultSet;
	private ResultSetMetaData resultSetMetaData;

	
	public ResultSetTableModel( ResultSet resultSet )
	  {
	    this.resultSet = resultSet;
	    
	    try 
	    {
	      this.resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
	      System.out.println(resultSet.getMetaData().getColumnName(1));
	    } 
	    catch (SQLException e) 
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
	@Override
	  public int getColumnCount()
	  {
		try 
	    {
	      return resultSetMetaData.getColumnCount();
	    } 
	    catch (SQLException e) 
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	      return 0;
	    }
	  }
	
	   @Override 
       public String getColumnName(int index) { 
           try {
			return resultSet.getMetaData().getColumnLabel(index+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
       } 
	  
		@Override
	  public int getRowCount()
	  {
		try
	    {
	      resultSet.last();
	      return resultSet.getRow();
	    } 
		catch (SQLException e)
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	      return 0;
	    }
	  }

		@Override
	  public Object getValueAt(int rowIndex, int columnIndex) 
	  {
	    try
	    {
	      resultSet.absolute( rowIndex + 1 );
	      return resultSet.getObject(columnIndex + 1 );
	    } 
	    catch (SQLException e)
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	      return null;
	    }
	  }
	  

}