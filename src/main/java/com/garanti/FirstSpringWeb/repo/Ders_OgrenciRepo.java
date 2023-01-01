package com.garanti.FirstSpringWeb.repo;


import com.garanti.FirstSpringWeb.Constants;
import com.garanti.FirstSpringWeb.model.Ders_Ogrenci;

import java.sql.*;
import java.util.ArrayList;

public class Ders_OgrenciRepo {

    public ArrayList<Ders_Ogrenci> getAll() {
        ArrayList<Ders_Ogrenci> liste = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;
        try {
            connection = Constants.getConnection();
            stmt = connection.createStatement();
            result = stmt.executeQuery("select * from BILGE.DERS_OGRENCI");
            while (result.next()) {
                Ders_Ogrenci temp = new Ders_Ogrenci(result.getInt("ID"), result.getInt("DERS_ID"), result.getInt("OGRENCI_ID"), result.getInt("NOTE"), result.getInt("DEVAMSIZLIK"));
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

    public Ders_Ogrenci getById(int id) {
        Ders_Ogrenci dersOgrenci = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("select * from BILGE.DERS_OGRENCI where ID = ?");
            stmt.setInt(1, id);
            result = stmt.executeQuery();
            while (result.next()) {
                dersOgrenci = new Ders_Ogrenci(result.getInt("ID"), result.getInt("DERS_ID"), result.getInt("OGRENCI_ID"), result.getInt("NOTE"), result.getInt("DEVAMSIZLIK"));
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
        return dersOgrenci;
    }

    public boolean save(Ders_Ogrenci dersOgrenci) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("Insert Into BILGE.DERS_OGRENCI (DERS_ID,OGRENCI_ID) values (?,?)");
            stmt.setInt(1, dersOgrenci.getDERS_ID());
            stmt.setInt(2, dersOgrenci.getOGRENCI_ID());
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
            stmt = connection.prepareStatement("delete from BILGE.DERS_OGRENCI where ID = ?");
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
