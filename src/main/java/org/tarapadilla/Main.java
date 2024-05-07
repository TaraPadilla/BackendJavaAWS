package org.tarapadilla;
import jakarta.persistence.EntityManager;
import org.tarapadilla.model.Employee;
import org.tarapadilla.utils.UtilEntity;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UIMenu.showMenu();
    }
}