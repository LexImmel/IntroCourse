public class Main {
    public static void main(String[] args) {
        Employee[] emp = new Employee[10];
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
//Показать все данные сотрудников компании:
        for (Employee employee : emp) {
            System.out.println(employee.toString());
        }
//Подсчет общей суммы зарплат
        int sum = 0;
        for (Employee value : emp) {
            sum = sum + value.getSalary();
        }
        System.out.println("Траты на зарплату в месяц: " + sum);
//Вывод минимальной и максимальной зарплат
        int minSalary = emp[0].getSalary();
        int maxSalary = minSalary;
        for (Employee employee : emp) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            } else if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        System.out.println("Минимальная зарплата в компании: " + minSalary);
        System.out.println("Максимальная зарплата в компании: " + maxSalary);
//Вывод средней зарплаты
        int avgSalary = sum / emp.length;
        System.out.println("Средняя зарплата в компании: " + avgSalary);
//Вывод ФИО всех сотрудников
        for (Employee employee : emp) {
            System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getSecondName());
        }
        //////////////////////////////////////////////////////////////////////////
        System.out.println("Повышенная сложность.");
        //Индексация зарплаты на фиксированный процент
        for (Employee employee : emp) {
            employee.setSalary((int) (employee.getSalary() * 1.15));
            System.out.println(employee.toString());
        }

    }
}