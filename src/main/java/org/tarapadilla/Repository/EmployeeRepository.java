package org.tarapadilla.Repository;
import jakarta.persistence.EntityManager;
import org.tarapadilla.model.Employee;
import org.tarapadilla.utils.DatabaseConnection;
import org.tarapadilla.utils.UtilEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee>{

    static EntityManager em = UtilEntity.getEntityManager();

    /* Solo para JDBC
    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    } */

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employees = em.createQuery("select e from Employee e", Employee.class).getResultList();
        return employees;

        /*
        //List<Employee> employees = new ArrayList<>();
        try(Statement stmt = getConnection().createStatement();
            ResultSet myRes = stmt.executeQuery("SELECT * FROM employees"))
        { while (myRes.next()) {
           employees.add(createEmployee(myRes));
        }
        }*/
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        employee = em.find(Employee.class,id);
        return employee;
        /*
        try(PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * FROM employees WHERE id = ?"))
        {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery())
            { if (rs.next()) {employee = createEmployee(rs);}}
        }*/
    }

    @Override
    public void save(Employee employee) throws SQLException {
         String sql;
        boolean actualiza = employee.getId() != null && employee.getId() > 0;
        em.getTransaction().begin();
        if (!actualiza) {
            em.persist(employee);
        }else {
            em.merge(employee);
        }
        em.getTransaction().commit();
        /*
        if (actualiza)
            sql = "UPDATE employees SET first_name = ?,pa_surname=?,ma_surname=?,email=?,salary=? WHERE id = ?";
        else {
            sql = "INSERT INTO employees(first_name,pa_surname,ma_surname,email,salary) VALUES (?, ?, ?,?,?)";
        }
        try(PreparedStatement stm = getConnection().prepareStatement(sql)){
          if (actualiza) {stm.setInt(6,employee.getId());}
            stm.setString(1,employee.getFirst_name());
            stm.setString(2,employee.getPa_surname());
            stm.setString(3,employee.getMa_surname());
            stm.setString(4,employee.getEmail());
            stm.setFloat(5,employee.getSalary());
            stm.executeUpdate();
        }*/
    }

    @Override
    public void delete(Employee emp) throws SQLException {
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
        /*String sql = "DELETE FROM employees WHERE id = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,emp.getId());
            statement.executeUpdate();
        }*/
    }

    private static Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee emp = new Employee();
        emp.setId(myRes.getInt("id"));
        emp.setFirst_name(myRes.getString("first_name"));
        emp.setPa_surname(myRes.getString("pa_surname"));
        emp.setMa_surname(myRes.getString("ma_surname"));
        emp.setEmail(myRes.getString("email"));
        emp.setSalary(myRes.getFloat("salary"));
        return emp;
    }

}
