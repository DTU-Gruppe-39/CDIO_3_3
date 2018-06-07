package user;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DTO.FoundException;
import DTO.NotFoundException;
import DTO.Raavare;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;

@Path("/raavare")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class RaavareResources {

	private static ArrayList <Raavare> raavareList = new ArrayList<>();
	MySQLRaavareDAO test = new MySQLRaavareDAO();	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String submit(Raavare rav) throws FoundException, DALException, SQLException
	{
		
		String result = test.createRaavare(rav);
//		System.out.println("Created raavare: " + rav.toString());
//		System.out.println("Current list " + raavareList.toString());

		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public ArrayList<Raavare> getRaavare() throws DALException, SQLException{
		raavareList = (ArrayList<Raavare>) test.getRaavareList();
		return raavareList;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON) 
	public String update(Raavare rav) throws NotFoundException, DALException, SQLException {
		
		String result = test.updateRaavare(rav);
		return result;
	}
}