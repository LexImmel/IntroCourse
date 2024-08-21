public class Main {

    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook(7);
        employeeBook.addEmployee(EmployeeConstants.director);
        employeeBook.addEmployee(EmployeeConstants.assistant);
        employeeBook.addEmployee(EmployeeConstants.assistant_engineer);
        employeeBook.addEmployee(EmployeeConstants.designer);
        employeeBook.addEmployee(EmployeeConstants.economist);
        employeeBook.addEmployee(EmployeeConstants.engineer);
        employeeBook.addEmployee(EmployeeConstants.engineer2);
        employeeBook.printAllEmployees();
        employeeBook.deleteEmployee(2); //Удаление сотрудника
        employeeBook.addEmployee(EmployeeConstants.secretary); //Добавление сотрудника
        employeeBook.printAllEmployees();

        System.out.println("Основная часть.");

        employeeBook.printAllEmployees();
        int total = employeeBook.calculateSumSalary();
        System.out.println("Общая сумма зарплат: " + total);
        Employee minSalaryEmployee = employeeBook.findEmployeeMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee);
        Employee maxSalaryEmployee = employeeBook.findEmployeeMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);
        double avgSalary = employeeBook.calculateAvgSalary();
        System.out.println("Среднее значение зарплат: " + avgSalary);
        employeeBook.printEmployeeFullNames();
        System.out.println(" ");

        System.out.println("Повышенная сложность.");
        int setPercent = 15; //Процент для подсчета ЗП
        employeeBook.countIndexedSalary(setPercent);//Подсчет относительно указанного процента
        employeeBook.printAllEmployees();
        int setDept = 1; //Номер департамента для подсчетов
        //Все данные ниже можно увидеть о каждом отделе, указав сверху номер отдела
        System.out.println("Зарплата отдела " + setDept + " равна: " + employeeBook.salaryOfDept(setDept));
        System.out.println("Средняя зарплата отдела " + setDept + " равна: " + employeeBook.deptAvgSalary(setDept));
        System.out.println("Минимальная зп в отделе " + setDept + " равна: " + employeeBook.minSalaryOfDept(setDept));
        System.out.println("Максимальная зп в отделе " + setDept + " равна: " + employeeBook.maxSalaryOfDept(setDept));
        employeeBook.countIndSalaryDept(setDept, setPercent);
        System.out.println("Проиндексированная зп в отделе: ");
        employeeBook.printDeptEmployees(setDept);
        int lowestSalary = 180_000;
        int highestSalary = 280_000;
        System.out.println("У указанных сотрудников зарплата ниже " + lowestSalary);
        employeeBook.salaryLesserThan(lowestSalary);
        System.out.println("У указанных сотрудников зарплата выше или равна " + highestSalary);
        employeeBook.salaryHigherThan(highestSalary);
        int binId = 1;//Поиск по ID
        System.out.println("Поиск по Id: " + binId);
        employeeBook.getEmployeeFromId(binId);
    }
}