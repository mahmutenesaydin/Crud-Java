package com.uniyaz.db;

import com.uniyaz.domian.Rehber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKARTAL on 3.3.2021.
 */
public class DbOperations {

    public void rehbbereEkle(String isim, String telefon) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO REHBER (ISIM, TELEFON) VALUE ('%s', '%s')";
        sql = String.format(sql, isim, telefon);

        try (
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "12345");
               PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rehberiGuncelle(int id, String isim, String telefon) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "Update REHBER set id=?, isim=?, telefon=? where ID ="+id;
        sql = String.format(sql, id, isim, telefon);

        try
        (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "12345");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        )
        {
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,isim);
            preparedStatement.setString(3,telefon);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void rehberiSil (int id) throws SQLException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "DELETE FROM REHBER WHERE id="+id;
        sql = String.format(sql, id);

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "12345");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        )
        {
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Rehber> rehberiGetir () {

        List<Rehber> rehberList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM REHBER";

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "12345");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String isim = resultSet.getString("ISIM");
                String telefon = resultSet.getString("TELEFON");
                Rehber rehber = new Rehber(id, isim, telefon);
                rehberList.add(rehber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rehberList;
    }
}
      /*  Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        try
        {
            connection = dbHelper.getConnection();
            String sql = "delete from city where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Kayıt Silindi");
        }
        catch (SQLException exception)
        {
            System.out.println(exception.getMessage());
        }
        finally
        {
            preparedStatement.close();
            connection.close();
        }
    }
*/

