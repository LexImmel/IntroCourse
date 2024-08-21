import java.util.Objects;

public final class Employee {
    private static int counter = 0;
    private final String name;
    private final String secondName;
    private final String surname;
    private int department;
    private int salary;
    private int id;


    public Employee(String surname, String name, String secondName, int department, int salary) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.id = ++counter;
    }

    public String getFullName() {
        return surname + " " + name + " " + secondName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отделов только пять.");
        }
    }

    @Override
    public String toString() {
        return "Фамилия сотрудника: " + surname + " Имя: " + name + " Отчество: " + secondName + " Код отдела: " + department + " Зарплата: " + salary + " Id: " + getId();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, secondName, name, department, salary, id);
    }

}

