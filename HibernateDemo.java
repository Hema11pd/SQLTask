package hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class HibernateDemo {
    public static void main(String[] args) {

        Employee employees = new Employee();
        Configuration configuration = new Configuration().configure()
                  .addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Scanner scanner = new Scanner(System.in);
        for(int i=1;i<=5;i++) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            System.out.println("Enter details for person " + i + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            employees.setEname(name);
            System.out.print("empage: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            employees.setEmpage(age);
            System.out.print("salary: ");
            int salary = scanner.nextInt();
            scanner.nextLine();
            employees.setEsalary(salary);
            session.save(employees);
            transaction.commit();
        }




    }
}
