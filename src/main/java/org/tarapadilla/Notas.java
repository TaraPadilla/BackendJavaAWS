package org.tarapadilla;

public class Notas {
/*
    pstmt = con.prepareStatement("insert into employees (first_name, ma_surname) values ('Tara','Padilla')");
    int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected > 0){
        System.out.println("Se creo empleado");
    }

    String mysql = "UPDATE employees SET email = ? WHERE first_name = ?";
    pstmt = con.prepareStatement(mysql);
            pstmt.setString(1, "tara@gmail.com");
            pstmt.setString(2, "Tara");
    rowsAffected = pstmt.executeUpdate();

            if(rowsAffected > 0){
        System.out.println("Se actualizo empleado");
    }

    mysql = "DELETE FROM employees WHERE email is null";
    pstmt = con.prepareStatement(mysql);
    rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0){
        System.out.println("Se eliminaron " +rowsAffected+" empleado");
    }

        try (Connection con = DatabaseConnection.getInstanceWithCon();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from employees");)
        {
            while (rs.next()) {
                System.out.println("Nombre " + rs.getString("first_name") +
                        " Email:" + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

            employee.setFirst_name("Ultima");
            employee.setPa_surname("test");
            employee.setMa_surname("insertando");
            employee.setSalary(250000);
            employee.setEmail("prueba@gmail.com");
            repository.save(employee);
            System.out.println("---- Actualizando ----");


    */

}
