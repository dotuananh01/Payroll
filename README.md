# Payroll
Bài tập buổi 3-4-5
Phần mềm tính lương phiên bản 1.0
    Hãy viết ứng dụng tính lương gồm các tính năng như sau:
    Đọc vào danh sách nhân viên dạng file CSV gồm các trường:
    name: họtên
    dob: ngày sinh
    role: chức vụ[director,manager,sales,engineer,staff,worker]
    startdate: ngày bắt đầu làm việc ở công ty
    startsal: mức lương khởi điểm

    In ra màn hình tính đến ngày hôm nay:
    Tuổi hiện tại của nhân viên
    Số năm và tháng làm việc. Làm tròn xuống, 3 năm, 2 tháng 15 ngày --> 3 năm, 2 tháng

    Công thức tăng lương theo thâm niên phiên bản 1.0:
    Bất kỳ nhân viên nào không quan tâm đến chức vụ, cứ làm đủ 12 tháng là tăng một bậc lương 6% so với mức lương cũ. 
    Cách tính này không cần đến đầu năm mới điều chỉnh.
    Hãy tính lương tại thời điểm hiện tại của nhân viên

=======================================================================================================================
1. File CSV:(https://github.com/dotuananh01/Payroll/blob/master/employee.csv) Lưu thông tin nhân viên
  Gồm 5 cột: name, dob, role, startdate, startsal

2. Tạo đối tượng Constant:(https://github.com/dotuananh01/Payroll/blob/master/Payroll/src/net/luvina/dotuananh/constant/Constant.java)
   Khai báo tập trung các hằng số.

3. Tạo đối tương Employee:
  (https://github.com/dotuananh01/Payroll/blob/master/Payroll/src/net/luvina/dotuananh/model/Employee.java)
    private String name;
    private LocalDate dateOfBirth;
    private String role;
    private LocalDate startDate;
    private float startSalary;
  3.1 Tính thâm niên làm việc: Dùng Period.between(startDate,today)
    public String getSeniority()
  3.2 Tính lương(12 tháng tăng 6%): x năm -> startSalary*(1 + 0.06) mũ x
    public String getCurrentSalary()

4. Tạo đối tượng EmployeeController chứa các method đọc data từ file vào đối tượng nhân viên:
  (https://github.com/dotuananh01/Payroll/blob/master/Payroll/src/net/luvina/dotuananh/controller/EmployeeController.java)
  
  4.1 Đọc file csv:
    public static List<Employee> getEmployeeFromCSV(String csvFile)
  4.2 Đọc file excel:
    public static List<Employee> getEmployeeFromExcel(String excelFile)
5. Tạo hàm main để test:https://github.com/dotuananh01/Payroll/blob/master/Payroll/src/net/luvina/dotuananh/main/main.java
