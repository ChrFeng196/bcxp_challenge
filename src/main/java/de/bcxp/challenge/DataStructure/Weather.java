package de.bcxp.challenge.DataStructure;

/**
 * Weather-object which represents the weather of a day in the month
 */
public class Weather {
	private int Day; 
	private int MaximumTemperature;
	private int MinimumTemperature;
	private int AverageTemperature;
	private double AvDP;
	private int OneHrP_TPcpn;
	private int PDir;
	private double AvSp;
	private int Dir;
	private int MxS;
	private double SkyC;
	private int MxR;
	private int Mn;
	private double R_AvSLP;

	/**
	 * Constructor
	 */
	public Weather() {
		
	}
	
	public Weather(int day, int minTemperature, int maxTemperature) {
		this.Day = day;
		this.MinimumTemperature = minTemperature;
		this.MaximumTemperature = maxTemperature;
	}
	
	public int getTemperatureSpread() {
		return Math.abs(this.MaximumTemperature - this.MinimumTemperature);
	}
	
	/*
	 * Getters and Setters
	 */
	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getMaximumTemperature() {
		return MaximumTemperature;
	}

	public void setMaximumTemperature(int maximumTemperature) {
		MaximumTemperature = maximumTemperature;
	}

	public int getMinimumTemperature() {
		return MinimumTemperature;
	}

	public void setMinimumTemperature(int minimumTemperature) {
		MinimumTemperature = minimumTemperature;
	}

	public int getAverageTemperature() {
		return AverageTemperature;
	}

	public void setAverageTemperature(int averageTemperature) {
		AverageTemperature = averageTemperature;
	}

	public double getAvDP() {
		return AvDP;
	}

	public void setAvDP(double avDP) {
		AvDP = avDP;
	}

	public int getOneHrP_TPcpn() {
		return OneHrP_TPcpn;
	}

	public void setOneHrP_TPcpn(int oneHrP_TPcpn) {
		OneHrP_TPcpn = oneHrP_TPcpn;
	}

	public int getPDir() {
		return PDir;
	}

	public void setPDir(int pDir) {
		PDir = pDir;
	}

	public double getAvSp() {
		return AvSp;
	}

	public void setAvSp(double avSp) {
		AvSp = avSp;
	}

	public int getDir() {
		return Dir;
	}

	public void setDir(int dir) {
		Dir = dir;
	}

	public int getMxS() {
		return MxS;
	}

	public void setMxS(int mxS) {
		MxS = mxS;
	}

	public double getSkyC() {
		return SkyC;
	}

	public void setSkyC(double skyC) {
		SkyC = skyC;
	}

	public int getMxR() {
		return MxR;
	}

	public void setMxR(int mxR) {
		MxR = mxR;
	}

	public int getMn() {
		return Mn;
	}

	public void setMn(int mn) {
		Mn = mn;
	}

	public double getR_AvSLP() {
		return R_AvSLP;
	}

	public void setR_AvSLP(double r_AvSLP) {
		R_AvSLP = r_AvSLP;
	}
}
