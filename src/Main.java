public class Main {

    public static Employee createEmployee(String name, String surname, String secondName, int department, int salary) {
        Employee employee = new Employee(name, surname, secondName, department, salary);
        return employee;
    }

    private static  Employee[] emp = new Employee[10];

    public static void main(String[] args) {

        emp[0] = new Employee("Волков", "Игорь", "Петрович", 1, 200_000);
        emp[1] = new Employee("Драник", "Влад", "Константинович", 2, 150_000);
        emp[2] = new Employee("Фрай", "Макс", "Филиппович", 3, 280_000);
        emp[3] = new Employee("Петрова", "Клавдия", "Петровна", 4, 190_000);
        emp[4] = new Employee("Рыжиков", "Вольдемар", "Николаевич", 5, 110_000);
        emp[5] = new Employee("Джонс", "Кэтрин", "Зета", 1, 210_000);
        emp[6] = new Employee("Крапивина", "Дарья", "Алексеевна", 2, 240_000);
        emp[7] = new Employee("Этвуд", "Мария", "Вадимовна", 3, 245_000);
        emp[8] = new Employee("Веркин", "Эдуард", "Владимирович", 4, 155_000);
        emp[9] = new Employee("Горох", "Надежда", "Яковлевна", 5, 200_000);

        System.out.println("Основная часть.");

        printAllEmployees();
        int total = calculateSumSalary();
        System.out.println("Общая сумма зарплат: " + total);
        Employee minSalaryEmployee = findEmployeeMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee);
        Employee maxSalaryEmployee = findEmployeeMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);
        double avgSalary = calculateAvgSalary();
        System.out.println("Среднее значение зарплат: " + avgSalary);
        printEmployeeFullNames();
        System.out.println(" ");

        System.out.println("Повышенная сложность.");
        int setPercent = 15; //Процент для подсчета ЗП
        int setDept = 1; //Номер департамента для подсчетов
        countIndexedSalary(setPercent);//Подсчет относительно указанного процента
        printAllEmployees();
        //Все данные ниже можно увидеть о каждом отделе, указав сверху номер отдела
        System.out.println("Зарплата отдела " + setDept + " равна: " + salaryOfDept(setDept));
        System.out.println("Минимальная зп в отделе " + setDept + " равна: " + minSalaryOfDept(setDept));
        System.out.println("Максимальная зп в отделе " + setDept + " равна: " + maxSalaryOfDept(setDept));
        countIndSalaryDept(setDept, setPercent);
        System.out.println("Проиндексированная зп в отделе: ");
        printDeptEmployees(setDept);
        int lowestSalary = 180_000;
        int highestSalary = 280_000;
        System.out.println("У указанных сотрудников зарплата ниже " + lowestSalary);
        salaryLesserThan(lowestSalary);
        System.out.println("У указанных сотрудников зарплата выше или равна " + highestSalary);
        salaryHigherThan(highestSalary);
    }

    //Показать все данные сотрудников компании:
    public static void printAllEmployees() {
        for (Employee employee : emp) {
            System.out.println(employee);
        }
    }

    //Показать данные по департаменту
    public static void printDeptEmployees(int dept) {
        System.out.println("Отдел номер " + dept + ":");
        for (Employee employee : emp) {
            if (employee.getDepartment() == dept) {
                System.out.println(" ФИО сотрудника: " + employee.getFullName() + " Зарплата: " + employee.getSalary() + " Id: " + employee.getId());
            }
        }
    }

    //Подсчет общей суммы зарплат
    public static int calculateSumSalary() {
        int total = 0;
        for (Employee employee : emp) {
            total += employee.getSalary();
        }
        return total;
    }

    //Вывод минимальной и максимальной зарплат
    public static Employee findEmployeeMinSalary() {
        if (emp.length == 0) return null;
        Employee minSalaryEmployee = emp[0];
        for (int i = 1; i < emp.length; i++) {
            if (emp[i].getSalary() < minSalaryEmployee.getSalary()) minSalaryEmployee = emp[i];
        }
        return minSalaryEmployee;
    }

    public static Employee findEmployeeMaxSalary() {
        if (emp.length == 0) return null;
        Employee maxSalaryEmployee = emp[0];
        for (int i = 1; i < emp.length; i++) {
            if (emp[i].getSalary() > maxSalaryEmployee.getSalary()) maxSalaryEmployee = emp[i];
        }
        return maxSalaryEmployee;
    }

    //Вывод средней зарплаты
    public static double calculateAvgSalary() {
        if (emp.length == 0) return 0;
        return (double) calculateSumSalary() / emp.length;
    }

    //Вывод ФИО всех сотрудников
    public static void printEmployeeFullNames() {
        for (Employee employee : emp) {
            System.out.println(employee.getFullName());
        }
    }

    //////////////////////////////////////////////////////////////////////////
    //Индексация зарплаты на фиксированный процент
    public static void countIndexedSalary(int percent) {
        for (Employee employee : emp) {
            int currentSalary = employee.getSalary();
            employee.setSalary((int) (currentSalary * (percent / 100f + 1)));
        }
    }

    //Зп отдела
    public static int salaryOfDept(int dept) {
        int sum = 0;
        for (Employee employee : emp) {
            if (employee.getDepartment() == dept) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    //Мин зп в отделе
    public static int minSalaryOfDept(int dept) {
        int minSalaryDept = emp[0].getSalary();
        for (Employee employee : emp) {
            if (employee.getDepartment() != dept) {
                continue;
            }
            if (employee.getSalary() < minSalaryDept) {
                minSalaryDept = employee.getSalary();
            }
        }
        return minSalaryDept;
    }

    //Макс зп в отделе
    public static int maxSalaryOfDept(int dept) {
        int maxSalaryDept = emp[0].getSalary();
        for (Employee employee : emp) {
            if (employee.getDepartment() != dept) {
                continue;
            }
            if (employee.getSalary() > maxSalaryDept) {
                maxSalaryDept = employee.getSalary();
            }
        }
        return maxSalaryDept;
    }

    //Проиндексированная зп в указанном отделе на указанный процент
    public static void countIndSalaryDept(int dept, int percent) {
        for (Employee employee : emp) {
            int currentSalary = employee.getSalary();
            if (employee.getDepartment() == dept) {
                employee.setSalary((int) (currentSalary * (percent / 100f + 1)));

            }
        }
    }

    public static void salaryLesserThan(int lowestSalary) {
        for (Employee employee : emp) {
            if (employee.getSalary() < lowestSalary) {
                System.out.println(" ФИО сотрудника: " + employee.getFullName() + " Зарплата: " + employee.getSalary() + " Id: " + employee.getId());
            }
        }
    }

    public static void salaryHigherThan(int highestSalary) {
        for (Employee employee : emp) {
            if (employee.getSalary() >= highestSalary) {
                System.out.println(" ФИО сотрудника: " + employee.getFullName() + " Зарплата: " + employee.getSalary() + " Id: " + employee.getId());
            }
        }
    }

}