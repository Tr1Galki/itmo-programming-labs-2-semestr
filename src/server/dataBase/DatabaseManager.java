package server.dataBase;



import data.vehiclec.Vehicle;

import java.sql.*;

import java.util.HashMap;

public class DatabaseManager {

    private static String password = ":)";

    public static void addLoginToDatabase(String login, String password){
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
            c.setAutoCommit(false);
            Statement statement = c.createStatement();

            String sql = "INSERT INTO users(login, password) VALUES" + "(" + "'" + login + "'" + ", " +
                    "'" + password + "'" + " )";
            statement.executeUpdate(sql);
            statement.close();
            c.commit();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static HashMap<String, String> getFromDatabase(){
        HashMap<String, String> users1 = new HashMap<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
            c.setAutoCommit(false);

            PreparedStatement sql = c.prepareStatement("SELECT * FROM users");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                users1.put(rs.getString(1), rs.getString(2));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return users1;
    }

    public static void addVehicleToDatabase(Vehicle vehicle) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
            c.setAutoCommit(false);
            Statement statement = c.createStatement();

            String sql = "INSERT INTO vehiclecollection(owner, id, name, \"coordinate X\", \"coordinate Y\", \"engine power\", type, \"fuel type\", \"creation date\") VALUES" + "(" + "\'" + vehicle.getOwnerName() + "\'" + ", " + vehicle.getId() + ", " +
                    "'" + vehicle.getName() + "'" + ", " + vehicle.getCoordinateX() + ", " + vehicle.getCoordinates().getY() + ", "  + vehicle.getEnginePower() +   ", " + "'" + vehicle.getType() + "'" + ", " +
                    "'" + vehicle.getFuelType() + "'" + ", " + "'" + vehicle.getCreationDate() + "'" +  " )";
            statement.executeUpdate(sql);
            statement.close();
            c.commit();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void clearDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", password);
            c.setAutoCommit(false);
            Statement statement = c.createStatement();
            String sql = "TRUNCATE vehiclecollection";
            statement.executeUpdate(sql);
            statement.close();
            c.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void removeVehicleByFuel(String str) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "QAZwsx5709as");
            c.setAutoCommit(false);
            Statement statement = c.createStatement();
            String sql = "DELETE FROM vehiclecollection" +
                    "\n WHERE \"fuel type\" = " + "'" + str + "'";
            statement.executeUpdate(sql);
            statement.close();
            c.commit();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}