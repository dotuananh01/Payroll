package net.luvina.dotuananh.main;
import net.luvina.dotuananh.constant.Constant;
import net.luvina.dotuananh.controller.EmployeeController;
import net.luvina.dotuananh.model.Employee;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String csvFile = Constant.CSV_FILE_PATH;
        List<Employee> employeesFromCSV = EmployeeController.getEmployeeFromCSV(csvFile);
        for (Employee employee : employeesFromCSV) {
            System.out.println(employee.getName() + " " + employee.calculateAge() + " tuổi ");
            System.out.println(employee.getSeniority());
            System.out.println("Current Salary: " + employee.getCurrentSalary());
        }

        String excelFile = Constant.EXCEL_FILE_PATH;
        List<Employee> employeesFromExcel = EmployeeController.getEmployeeFromExcel(excelFile);
        for (Employee employee : employeesFromExcel) {
            System.out.println(employee.getName() + " " + employee.calculateAge() + " tuổi ");
            System.out.println(employee.getSeniority());
            System.out.println("Current Salary: " + employee.getCurrentSalary());
        }
    }
}


