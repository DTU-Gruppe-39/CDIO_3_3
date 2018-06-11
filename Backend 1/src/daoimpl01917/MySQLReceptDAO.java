package daoimpl01917;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import JDBC.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptDAO;
import DTO.FoundException;
import DTO.Recept;

public class MySQLReceptDAO implements ReceptDAO {

	/**
	 * Returns a list of recept products 
	 */
	@Override
	public List<Recept> getReceptList() throws DALException, SQLException {
		List<Recept> list = new ArrayList<Recept>();
		
		Connection conn = Connector.getConn();
		PreparedStatement getRecepList = null;
		ResultSet rs = null;

		String getRcptList = "SELECT * FROM recept";

		try {
			getRecepList = conn.prepareStatement(getRcptList);
			rs = getRecepList.executeQuery();
			while (rs.next()) 
			{
				list.add(new Recept(rs.getInt("recept_id"), rs.getString("recept_navn")));
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			if (getRecepList != null) {
				getRecepList.close();
			}
		}
		return list;
	}

	/**
	 * Opretter en recept i databasen og dens komponenter relateret.
	 */
	@Override
	public String createRecept(Recept recept) throws DALException, SQLException, FoundException {
		Connection conn = Connector.getConn();
		PreparedStatement createRec = null;
		
		String createRecept = "INSERT INTO recept (recept_id, recept_navn) VALUES (?,?)";
		try {
			createRec = conn.prepareStatement(createRecept);

			createRec.setInt(1, recept.getReceptId());
			createRec.setString(2, recept.getReceptNavn());
			createRec.executeUpdate();
		} catch(MySQLIntegrityConstraintViolationException e)
		{
			//throw exception hvis et id allerede eksisterer
			throw new FoundException("Recept Id already exists");
		}
		catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			if (createRec != null) {
				createRec.close();
			}
		}
		//Inds�tter komponenter relateret til den oprettede recept
		MySQLReceptKompDAO t = new MySQLReceptKompDAO();
		try 
		{		
			for(int j = 0; j < recept.getReceptKomponent().size(); j++) {
				t.createReceptKomp(recept.getReceptKomponent().get(j));
			}
		}catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		//endelige return string
		return "Recept oprettet";
	}
}