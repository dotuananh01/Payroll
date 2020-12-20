package net.luvina.dotuananh.controller;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import net.luvina.dotuananh.constant.Constant;
import net.luvina.dotuananh.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmployeeController {
    public static List<Employee> getEmployeeFromCSV(String csvFile) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            File file = new File(csvFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(fileReader);
            String line = "";
            String[] rowElements;

            while ((line = bufReader.readLine()) != null) {
                if(line.isEmpty() || line.equals(Constant.CSV_HEADER)){
                    continue;
                }
                rowElements = line.split(Constant.DELIMITER);
                employees.add(mappingEmployee(rowElements));
            }
            bufReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return employees;
    }

    private static Employee mappingEmployee(String[] rowElements){
        Employee employee = new Employee();
        for (int columnIndex = 0; columnIndex < rowElements.length; columnIndex++) {
            switch (columnIndex) {
                case 0:
                    employee.setName(rowElements[columnIndex]);
                    break;
                case 1:
                    employee.setDateOfBirth(LocalDate.parse(rowElements[columnIndex],Constant.DATE_TIME_FORMATTER));
                    break;
                case 2:
                    employee.setRole(rowElements[columnIndex]);
                    break;
                case 3:
                    employee.setStartDate(LocalDate.parse(rowElements[columnIndex],Constant.DATE_TIME_FORMATTER));
                    break;
                case 4:
                    employee.setStartSalary(Float.parseFloat(rowElements[columnIndex]));
                    break;
                default:
                    System.out.println("Column index out of range!!!");
            }
        }
        return employee;
    }

    public static List<Employee> getEmployeeFromExcel(String excelFile) {

        ArrayList<Employee> employees = new ArrayList<>();
        try{
            Workbook workbook;
            try (FileInputStream inputStream = new FileInputStream(new File(excelFile))) {
                workbook = new XSSFWorkbook(inputStream);
            }

            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            boolean isFirstRow = true;
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                if(isFirstRow){
                    isFirstRow = false;
                    continue;
                }

                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Employee employee = new Employee();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            employee.setName(cell.getStringCellValue());
                            break;
                        case 1:
                            employee.setDateOfBirth(cell.getLocalDateTimeCellValue().toLocalDate());
                            break;
                        case 2:
                            employee.setRole(cell.getStringCellValue());
                            break;
                        case 3:
                            employee.setStartDate(cell.getLocalDateTimeCellValue().toLocalDate());
                            break;
                        case 4:
                            employee.setStartSalary((float) cell.getNumericCellValue());
                            break;
                        default:
                            System.out.print("Column index out of range!!!");
                    }
                }
                employees.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return employees;
    }
}
