package DB_layer;
import java.sql.*;

public class UserDB
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/castuskonkurrence";

    //  Database credentials
    static final String USER = "devuser";
    static final String PASS = "123";

    public void insertIntoDB (String sNavn, String sHar_Boern, int sAntal_Boern, int sTLF, String sEmail, String sAdresse, String sFavorite_Produkt)
    {
        Connection conn = null;
        Statement stmt = null;
        try
        {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting records into the tables...");
            stmt = conn.createStatement();

            String sql ="insert into kunder(Navn, Har_Boern, Antal_Boern, TLF, Email, Adresse, Favorite_Produkt)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";
            String sql1 ="insert into kunder_tilmeldt(Navn, Har_Boern, Antal_Boern, TLF, Email, Adresse, Favorite_Produkt)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, sNavn);
            preparedStatement.setString(2, sHar_Boern);
            preparedStatement.setInt(3, sAntal_Boern);
            preparedStatement.setInt(4, sTLF);
            preparedStatement.setString(5, sEmail);
            preparedStatement.setString(6, sAdresse);
            preparedStatement.setString(7, sFavorite_Produkt);

            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setString(1, sNavn);
            preparedStatement1.setString(2, sHar_Boern);
            preparedStatement1.setInt(3, sAntal_Boern);
            preparedStatement1.setInt(4, sTLF);
            preparedStatement1.setString(5, sEmail);
            preparedStatement1.setString(6, sAdresse);
            preparedStatement1.setString(7, sFavorite_Produkt);

            preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();
            System.out.println("Inserted records into the table...");

        } catch (SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se)
            {
            }// do nothing
            try
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    private void reduceRedundentcy()
    {

    }
}
