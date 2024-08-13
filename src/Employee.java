public final class Employee {
    private final String name;
    private final String secondName;
    private final String surname;
    private final int department;
    private int salary;
    private static int id;


    public Employee(String surname, String name, String secondName, int department, int salary) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.id = 1;
    }

    public String getName() {
        return name;
    }
    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
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
        return id++;
    }

    public String toString() {
        return "Фамилия сотрудника: " + surname + " Имя: " + name + " Отчество "+ secondName + " Код отдела: " + department + " Зарплата: " + salary + " Id: " + getId();
    }


}

