package net.luvina.dotuananh.constant;

import java.time.format.DateTimeFormatter;

public class Constant {
    public static final int SALARY_INCREASE_PERIOD          = 12;
    public static final float INCREASE_PERCENT              = 0.06f;
    public static final String SENIORITY_FORMAT             = "Seniority: %d năm, %d tháng";
    public static final String TO_STRING_FORMAT             = "%s _ %s _ %s _ %s _ %s _ %s _ %s";
    public static final String CSV_HEADER                   = "name,dob,role,startdate,salary";
    public static final String DELIMITER                    = ",";
    public static final String CSV_FILE_PATH                = "employee.csv";
    public static final String EXCEL_FILE_PATH              = "employee.xlsx";
    public static DateTimeFormatter DATE_TIME_FORMATTER     = DateTimeFormatter.ofPattern("yyyyMMdd");
}
