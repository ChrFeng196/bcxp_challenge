package de.bcxp.challenge.DataStructure;

/**
 * Country-object which keeps information about a country
 */
public class Country {
	private String Name;
	private String Capital;
	private int Accession;
	private long Population;
	private double Area_inSquareKm;
	private long Gdp_inUSD;
	private double HumanDevelopmentIndex;
	private int Meps;

	/**
	 * Constructor
	 */
	public Country() {
		
	}
	
	public Country(String name, long population, double area) {
		this.Name = name;
		this.Population = population;
		this.Area_inSquareKm = area;
	}
	
	/*
	 * Functions
	 */
	public double calculatePopulationDensity() {
		return this.Population / this.Area_inSquareKm;
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

	public double getArea_inSquareKm() {
		return Area_inSquareKm;
	}

	public void setArea_inSquareKm(double area_inSquareKm) {
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
