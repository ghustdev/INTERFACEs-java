package entities;

public class Invoice {
	private Double basicPayment;
	private Double tex;
	
	public Invoice() {}
	
	public Invoice(Double basicPayment, Double tex) {
		this.basicPayment = basicPayment;
		this.tex = tex;
	}
	
	public Double getBasicPayment() {
		return basicPayment;
	}
	
	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}
	
	public Double getTex() {
		return tex;
	}
	
	public void setTex(Double tex) {
		this.tex = tex;
	}
	
	public Double getTotalPayment() {
		return getBasicPayment() + getTex();
	}
}
