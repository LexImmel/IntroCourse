public class EmployeeBook {

    private final Employee[] emp;

    public EmployeeBook(int size) {
        emp = new Employee[size];
    }

    public int size() {
        int size = 0;
        for (Employee employee : emp) {
            size++;
        }
        return size;
    }

    //Показать все данные сотрудников компании:
    public void printAllEmployees() {
        for (Employee employee : emp) {
            System.out.println(employee);
        }
    }

    //Показать данные по департаменту
    public void printDeptEmployees(int dept) {
        System.out.println("Отдел номер " + dept + ":");
        for (Employee employee : emp) {
            if (employee.getDepartment() == dept) {
                System.out.println(" ФИО сотрудника: " + employee.getFullName() + " Зарплата: " + employee.getSalary() + " Id: " + employee.getId());
            }
        }
    }

    //Подсчет общей суммы зарплат
    public int calculateSumSalary() {
        int total = 0;
        for (Employee employee : emp) {
            total += employee.getSalary();
        }
        return total;
    }

    //Вывод минимальной и максимальной зарплат
    public Employee findEmployeeMinSalary() {
        if (emp.length == 0) return null;
        Employee minSalaryEmployee = emp[0];
        for (int i = 1; i < emp.length; i++) {
            if (emp[i].getSalary() < minSalaryEmployee.getSalary()) minSalaryEmployee = emp[i];
        }
        return minSalaryEmployee;
    }

    public Employee findEmployeeMaxSalary() {
        if (emp.length == 0) return null;
        Employee maxSalaryEmployee = emp[0];
        for (int i = 1; i < emp.length; i++) {
            if (emp[i].getSalary() > maxSalaryEmployee.getSalary()) maxSalaryEmployee = emp[i];
        }
        return maxSalaryEmployee;
    }

    //Вывод средней зарплаты
    public double calculateAvgSalary() {
        if (emp.length == 0) return 0;
        return (double) calculateSumSalary() / emp.length;
    }

    //Вывод ФИО всех сотрудников
    public void printEmployeeFullNames() {
        for (Employee employee : emp) {
            System.out.println(employee.getFullName());
        }
    }

    //////////////////////////////////////////////////////////////////////////
    //Индексация зарплаты на фиксированный процент
    public void countIndexedSalary(int percent) {
        for (Employee employee : emp) {
            int currentSalary = employee.getSalary();
            employee.setSalary((int) (currentSalary * (percent / 100f + 1)));
        }
    }

    //Зп отдела
    public int salaryOfDept(int dept) {
        int sum = 0;
        for (Employee employee : emp) {
            if (employee.getDepartment() == dept) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public int deptEmployeeCount(int dept) {
        int count = 0;
        for (Employee employee : emp) {
            if (employee.getDepartment() == dept) {
                count++;
            }
        }
        return count;
    }

    public int deptAvgSalary(int dept) {
        return salaryOfDept(dept) / deptEmployeeCount(dept);
    }

    //Мин зп в отделе
    public int minSalaryOfDept(int dept) {
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
    public int maxSalaryOfDept(int dept) {
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
    public void countIndSalaryDept(int dept, int percent) {
        for (Employee employee : emp) {
            int currentSalary = employee.getSalary();
            if (employee.getDepartment() == dept) {
                employee.setSalary((int) (currentSalary * (percent / 100f + 1)));

            }
        }
    }

    public void salaryLesserThan(int lowestSalary) {
        for (Employee employee : emp) {
            if (employee.getSalary() < lowestSalary) {
                System.out.println(" ФИО сотрудника: " + employee.getFullName() + " Зарплата: " + employee.getSalary() + " Id: " + employee.getId());
            }
        }
    }

    public void salaryHigherThan(int highestSalary) {
        for (Employee employee : emp) {
            if (employee.getSalary() >= highestSalary) {
                System.out.println(" ФИО сотрудника: " + employee.getFullName() + " Зарплата: " + employee.getSalary() + " Id: " + employee.getId());
            }
        }
    }

    public Employee[] getEmployees() {
        return new Employee[0];
    }

    public void deleteEmployee(int index) {
        emp[index] = null;
    }

    public void getEmployeeFromId(int setId) {
        for (Employee employee : emp) {
            if (employee.getId() == setId) {
                System.out.println(employee);
            }
        }
    }

    public void addEmployee(Employee newEmployee) {
        boolean result = false;
        for (int i = 0; i < emp.length; i++) {
            if (emp[i] == null) {
                emp[i] = newEmployee;
                return;
            }
        }
    }
}
