package LinkedIn;

import java.sql.*;

public class App
{
    public static void main( String[] args )
    {
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=DoctorWho;user=sa;password=Password1234";
        Connection conn = null;

        System.out.println("Connecting to database .....");

        try
        {
            conn = DriverManager.getConnection(connectionURL);
            System.out.println("Successful!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        // Insert demo
        System.out.print("Inserting a new row into table, press ENTER to continue...");
        String query = "Insert into tblDoctor (DoctorNumber, DoctorName, Birthdate, FirstEpisodeDate, LastEpisodeDate) Values(?,?,?,?,?)";
        try(PreparedStatement statement = conn.prepareStatement(query))
        {
            statement.setInt(1,13);
            statement.setString(2, "Koosha");
            statement.setDate(3, Date.valueOf("1995-01-04"));
            statement.setDate(4, Date.valueOf("2020-01-01"));
            statement.setDate(5, Date.valueOf("2020-02-01"));
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        // Read demo
        System.out.println("Reading data from a table");
        query = "select doctorName, FirstEpisodeDate from tblDoctor;";
        try(Statement statement = conn.createStatement(); ResultSet results = statement.executeQuery(query))
        {
            while(results.next())
            {
                System.out.println(results.getString(1) + " " + results.getDate(2));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        // Delete demo
        String userToDelete = "Koosha";
        System.out.print("Deleting doctor " + userToDelete);
        query = "Delete from tblDoctor where doctorName = ?;";
        try(PreparedStatement statement = conn.prepareStatement(query))
        {
            statement.setString(1, userToDelete);
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        System.out.println("Reading data from a table");
        query = "select doctorName, FirstEpisodeDate from tblDoctor;";
        try(Statement statement = conn.createStatement(); ResultSet results = statement.executeQuery(query))
        {
            while(results.next())
            {
                System.out.println(results.getString(1) + " " + results.getDate(2));
            }
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
}
