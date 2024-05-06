package org.tarapadilla;
import jakarta.persistence.EntityManager;
import org.tarapadilla.model.Employee;
import org.tarapadilla.utils.UtilEntity;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery("select e from Employee e", Employee.class).getResultList();
        System.out.println("---- Listado completo ---");
        employees.forEach(System.out::println);

        //UIMenu.showMenu();
    }
}