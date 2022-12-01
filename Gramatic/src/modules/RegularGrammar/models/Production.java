package modules.RegularGrammar.models;

public class Production {
	
	private String production;
	private String axiomaticSymbol;
	/**
	 * @param production
	 * @param axiomaticSymbol
	 */
	public Production(String axiomaticSymbol, String production) {
		this.production = production;
		this.axiomaticSymbol = axiomaticSymbol;
	}
	/**
	 * @return the production
	 */
	public String getProduction() {
		return production;
	}
	/**
	 * @param production the production to set
	 */
	public void setProduction(String production) {
		this.production = production;
	}
	/**
	 * @return the axiomaticSymbol
	 */
	public String getAxiomaticSymbol() {
		return axiomaticSymbol;
	}
	/**
	 * @param axiomaticSymbol the axiomaticSymbol to set
	 */
	public void setAxiomaticSymbol(String axiomaticSymbol) {
		this.axiomaticSymbol = axiomaticSymbol;
	}
}