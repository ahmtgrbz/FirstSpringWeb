package com.garanti.FirstSpringWeb.repo;



import com.garanti.FirstSpringWeb.Constants;
import com.garanti.FirstSpringWeb.model.Ogretmen;

import java.sql.*;
import java.util.ArrayList;

public class OgretmenRepo {
    public ArrayList<Ogretmen> getAll() {
        ArrayList<Ogretmen> liste = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;
        try {
            connection = Constants.getConnection();
            stmt = connection.createStatement();
            result = stmt.executeQuery("select * from BILGE.OGRETMEN");
            while (result.next()) {
                Ogretmen temp = new Ogretmen(result.getInt("ID"), result.getString("NAME"), result.getBoolean("IS_GICIK"));
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

    public Ogretmen getById(int id) {
        Ogretmen ogretmen = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("select * from BILGE.OGRETMEN where ID = ?");
            stmt.setInt(1, id);
            result = stmt.executeQuery();
            while (result.next()) {
                ogretmen = new Ogretmen(result.getInt("ID"), result.getString("NAME"), result.getBoolean("IS_GICIK"));
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
        return ogretmen;
    }

    public boolean save(Ogretmen ogretmen) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("Insert Into BILGE.OGRETMEN (NAME,IS_GICIK) values (?,?)");
            stmt.setString(1, ogretmen.getNAME());
            stmt.setBoolean(2, ogretmen.isIS_GICIK());
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
            stmt = connection.prepareStatement("delete from BILGE.OGRETMEN where ID = ?");
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
