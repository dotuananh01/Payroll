package net.luvina.dotuananh.model;

import net.luvina.dotuananh.constant.Constant;
import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String name;
    private LocalDate dateOfBirth;
    private String role;
    private LocalDate startDate;
    private float startSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public float getStartSalary() {
        return startSalary;
    }

    public void setStartSalary(float salary) {
        this.startSalary = salary;
    }

    private Period getPeriodFromStartWorkDay(){
        LocalDate   today = LocalDate.now();
        return Period.between(startDate,today);
    }

    public String getSeniority(){
        Period periodDate = getPeriodFromStartWorkDay();
        return String.format(Constant.SENIORITY_FORMAT, periodDate.getYears(), periodDate.getMonths());
    }

    public float getCurrentSalary(){
        float currentSalary = startSalary;
        Period periodDate = getPeriodFromStartWorkDay();
        int numberOfTimesIncrease = periodDate.getYears()*12/Constant.SALARY_INCREASE_PERIOD;
        for (int i = 1; i <= numberOfTimesIncrease ; i++) {
            currentSalary += Constant.INCREASE_PERCENT*currentSalary;
        }
        return currentSalary;
    }

    public int calculateAge(){
        LocalDate   today = LocalDate.now();
        return Period.between(dateOfBirth,today).getYears();
    }

    public String toString(){
        return String.format(Constant.TO_STRING_FORMAT, name, dateOfBirth, role, startDate, startSalary, getSeniority(), getCurrentSalary());
    }
}
