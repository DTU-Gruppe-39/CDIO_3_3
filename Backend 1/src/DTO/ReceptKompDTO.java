package DTO;

//Data Transfer object to hold information regarding one instance of ReceptKompDTO
public class ReceptKompDTO
{
	int receptId;       
	int raavareId;    
	double nomNetto;  
	double tolerance; 
	
	public ReceptKompDTO() {}
	
	public ReceptKompDTO(int receptId, int raavareId, double nomNetto, double tolerance)
	{
		this.receptId = receptId;
		this.raavareId = raavareId;
		this.nomNetto = nomNetto;
		this.tolerance = tolerance;
	}

	public int getReceptId() { return receptId; }
	public void setReceptId(int receptId) { this.receptId = receptId; }
	public int getRaavareId() { return raavareId; }
	public void setRaavareId(int raavareId) { this.raavareId = raavareId; }
	public double getNomNetto() { return nomNetto; }
	public void setNomNetto(double nomNetto) { this.nomNetto = nomNetto; }
	public double getTolerance() { return tolerance; }
	public void setTolerance(double tolerance) { this.tolerance = tolerance; }
	public String toString() { 
		return receptId + "\t" + raavareId + "\t" + nomNetto + "\t" + tolerance; 
	}
}