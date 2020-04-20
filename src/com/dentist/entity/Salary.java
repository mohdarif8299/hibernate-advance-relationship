package com.dentist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salary")
public  class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "gross_salary")
	private String grossSalary;

	@Column(name = "basic_salary")
	private String basicSalary;

	@Column(name = "house_rent_allowance")
	private String houseRentAllowance;

	@Column(name = "bonus")
	private String bonus;

	@Column(name = "mode_of_payment")
	private String modeOfPayment;

	public Salary(String grossSalary, String basicSalary, String houseRentAllowance, String bonus,
			String modeOfPayment) {
		super();
		this.grossSalary = grossSalary;
		this.basicSalary = basicSalary;
		this.houseRentAllowance = houseRentAllowance;
		this.bonus = bonus;
		this.modeOfPayment = modeOfPayment;
	}

	public Salary() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(String grossSalary) {
		this.grossSalary = grossSalary;
	}

	public String getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}

	public String getHouseRentAllowance() {
		return houseRentAllowance;
	}

	public void setHouseRentAllowance(String houseRentAllowance) {
		this.houseRentAllowance = houseRentAllowance;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", grossSalary=" + grossSalary + ", basicSalary=" + basicSalary
				+ ", houseRentAllowance=" + houseRentAllowance + ", bonus=" + bonus + ", modeOfPayment=" + modeOfPayment
				+ "]";
	}

}
