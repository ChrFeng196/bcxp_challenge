package de.bcxp.challenge.DataStructure;

/**
 * Country-object which keeps information about a country
 */
public class Country {
	private String Name;
	private String Capital;
	private int Accession;
	private long Population;
	private long Area_inSquareKm;
	private long Gdp_inUSD;
	private double HumanDevelopmentIndex;
	private int Meps;

	/**
	 * Constructor
	 */
	public Country() {
		
	}
	
	/*
	 * Getters and Setters
	 */
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCapital() {
		return Capital;
	}

	public void setCapital(String capital) {
		Capital = capital;
	}

	public int getAccession() {
		return Accession;
	}

	public void setAccession(int accession) {
		Accession = accession;
	}

	public long getPopulation() {
		return Population;
	}

	public void setPopulation(long population) {
		Population = population;
	}

	public long getArea_inSquareKm() {
		return Area_inSquareKm;
	}

	public void setArea_inSquareKm(long area_inSquareKm) {
		Area_inSquareKm = area_inSquareKm;
	}

	public long getGdp_inUSD() {
		return Gdp_inUSD;
	}

	public void setGdp_inUSD(long gdp_inUSD) {
		Gdp_inUSD = gdp_inUSD;
	}

	public double getHumanDevelopmentIndex() {
		return HumanDevelopmentIndex;
	}

	public void setHumanDevelopmentIndex(double humanDevelopmentIndex) {
		HumanDevelopmentIndex = humanDevelopmentIndex;
	}

	public int getMeps() {
		return Meps;
	}

	public void setMeps(int meps) {
		Meps = meps;
	}
}
