package DTO;

public class Afvejning {
//	private int userId;
//	private int rbId;
	private double tara;
	private double netto;
	private double brutto;


	public double getBrutto() {
		return brutto;
	}
	public void setBrutto(double brutto) {
		this.brutto = brutto;
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public int getRbId() {
//		return rbId;
//	}
//	public void setRbId(int rbId) {
//		this.rbId = rbId;
//	}
	public double getTara() {
		return tara;
	}
	public void setTara(double tara) {
		this.tara = tara;
	}
	public double getNetto() {
		return netto;
	}
	public void setNetto(double netto) {
		this.netto = netto;
	}
	
//	Copied from CDIO 2. Not sure if we need it.
//	public String toString(){
//		return "userId: " + Personer.getUserId() + " råvareBathcId: " + RaavareBatch.rbId
//				+ " taravægt: " + tara + " netto: "+ netto + " brutto: " 
//				+ brutto;
//	}
}
