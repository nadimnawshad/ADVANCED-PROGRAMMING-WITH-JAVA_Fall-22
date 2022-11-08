package com.domain;
import javax.validation.constraints.NotNull;

public class TaxForm {
    @NotNull(message = "Must Select a category")
    private int tax_payer_category;
    @NotNull(message = "Must Select a zone")
    private int tax_payer_zone;
    @NotNull(message = "Must input a basic Salary")
    private int basic_salary;

    @NotNull(message = "Must input a house rent")
    private int house_rent;
    @NotNull(message = "Must input a medical allowance")
    private int medical;
    @NotNull(message = "Must input a conveyance")
    private int conveyance;
    @NotNull(message = "Must input a commission")
    private int commission;
    @NotNull(message = "Must input a festival bonus")
    private int bonus;

    private int investment;

    public TaxForm() {
    }

    public void setTax_payer_category(int tax_payer_category) {
        this.tax_payer_category = tax_payer_category;
    }

    public int getTax_payer_category() {
        return tax_payer_category;
    }

    public void setTax_payer_zone(int tax_payer_zone) {
        this.tax_payer_zone = tax_payer_zone;
    }

    public int getTax_payer_zone() {
        return tax_payer_zone;
    }

    public void setBasic_salary(int basic_salary) {
        this.basic_salary = basic_salary;
    }

    public int getBasic_salary() {
        return basic_salary;
    }

    public void setHouse_rent(int house_rent) {
        this.house_rent = house_rent;
    }

    public int getHouse_rent() {
        return house_rent;
    }

    public void setMedical(int medical) {
        this.medical = medical;
    }

    public int getMedical() {
        return medical;
    }

    public void setConveyance(int conveyance) {
        this.conveyance = conveyance;
    }

    public int getConveyance() {
        return conveyance;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getCommission() {
        return commission;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setInvestment(int investment) {
        this.investment = investment;
    }

    public int getInvestment() {
        return investment;
    }
}
