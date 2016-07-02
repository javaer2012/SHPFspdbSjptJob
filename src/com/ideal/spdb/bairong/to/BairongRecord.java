package com.ideal.spdb.bairong.to;

public class BairongRecord {
	private SpecialList_c specialList_c;
	
	private ApplyLoan applyLoan;
	
	private Location location;
	
	private Stability_c stability_c;
	
	private Media_c media_c;
	
	private Consumption_c consumption_c;
	
	private Accountchange accountchange;
	
	private PayConsumption payConsumption;
	
	private Score score;
	
	private Authentication authentication;
	
	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public PayConsumption getPayConsumption() {
		return payConsumption;
	}

	public void setPayConsumption(PayConsumption payConsumption) {
		this.payConsumption = payConsumption;
	}

	public Accountchange getAccountchange() {
		return accountchange;
	}

	public void setAccountchange(Accountchange accountchange) {
		this.accountchange = accountchange;
	}

	public Consumption_c getConsumption_c() {
		return consumption_c;
	}

	public void setConsumption_c(Consumption_c consumption_c) {
		this.consumption_c = consumption_c;
	}

	public Media_c getMedia_c() {
		return media_c;
	}

	public void setMedia_c(Media_c media_c) {
		this.media_c = media_c;
	}

	public Stability_c getStability_c() {
		return stability_c;
	}

	public void setStability_c(Stability_c stability_c) {
		this.stability_c = stability_c;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ApplyLoan getApplyLoan() {
		return applyLoan;
	}

	public void setApplyLoan(ApplyLoan applyLoan) {
		this.applyLoan = applyLoan;
	}

	public SpecialList_c getSpecialList_c() {
		return specialList_c;
	}

	public void setSpecialList_c(SpecialList_c specialList_c) {
		this.specialList_c = specialList_c;
	}
}
