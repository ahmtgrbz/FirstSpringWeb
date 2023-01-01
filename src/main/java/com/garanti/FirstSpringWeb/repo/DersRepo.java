package com.garanti.FirstSpringWeb.repo;



import com.garanti.FirstSpringWeb.Constants;
import com.garanti.FirstSpringWeb.model.Ders;

import java.sql.*;
import java.util.ArrayList;

public class DersRepo {

    public ArrayList<Ders> getAll() {
        ArrayList<Ders> liste = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;
        try {
            connection = Constants.getConnection();
            stmt = connection.createStatement();
            result = stmt.executeQuery("select * from BILGE.DERS");
            while (result.next()) {
                Ders temp = new Ders(result.getInt("ID"), result.getInt("OGR_ID"), result.getInt("KONU_ID"));
                liste.add(temp);
            }
        } catch (Exception e) {
            liste.clear();
            System.err.println(e.getMessage());
        } finally {
            try {
                result.close();
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                // throw new mybussinessexception()
            }
        }
        return liste;
    }

    public Ders getById(int id) {
        Ders ders = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("select * from BILGE.DERS where ID = ?");
            stmt.setInt(1, id);
            result = stmt.executeQuery();
            while (result.next()) {
                ders = new Ders(result.getInt("ID"), result.getInt("OGR_ID"), result.getInt("KONU_ID"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                result.close();
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                // throw new mybussinessexception()
            }
        }
        return ders;
    }

    public boolean save(Ders ders) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("Insert Into BILGE.DERS (OGR_ID,KONU_ID) values (?,?)");
            stmt.setInt(1, ders.getOGR_ID());
            stmt.setInt(2, ders.getKONU_ID());
            result = stmt.executeUpdate() == 1;

        } catch (SQLException e) {
            System.err.println("->" + e.getClass().getName());
            System.err.println(e.getMessage());
        } catch (Exception e) {
            /*
            catch (PSQLException e)
        {
            if (e.getServerErrorMessage() != null)
            {
                System.err.println(e.getServerErrorMessage().getSchema());
                System.err.println(e.getServerErrorMessage().getConstraint());
                System.err.println(e.getServerErrorMessage().getHint());
                System.err.println(e.getServerErrorMessage().getTable());
                System.err.println(e.getServerErrorMessage().getSQLState());
                System.err.println(e.getServerErrorMessage().getSeverity());
                System.err.println(e.getServerErrorMessage().getRoutine());
                System.err.println(e.getServerErrorMessage().getPosition());
                System.err.println(e.getServerErrorMessage().getInternalQuery());
                System.err.println(e.getServerErrorMessage().getColumn());
                System.err.println(e.getServerErrorMessage().getWhere());
                System.err.println(e.getServerErrorMessage().getFile());
                System.err.println(e.getServerErrorMessage().getDetail());
                System.err.println(e.getServerErrorMessage().getMessage());
            }
            else
            {
                System.err.println("PSQL -> " + e.getLocalizedMessage());
            }
        }
        catch (SQLException e)
        {
            System.err.println("SQL -> " + e.getMessage());
        }
        catch (Exception e)
        {
            System.err.println("EXC -> " + e.getMessage());
        }
            * */

            System.err.println(e.getMessage());
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                // throw new mybussinessexception()
            }
        }
        return result;

    }

    public boolean deleteById(int id) {

        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("delete from BILGE.DERS where ID = ?");
            stmt.setInt(1, id);
            result = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                // throw new mybussinessexception()
            }
        }
        return result;

    }
}
