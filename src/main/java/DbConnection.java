import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
    private Connection connection;

    public DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banks", "root", "root" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void save(String userName, String surName, String departments){

String sql = "insert into user(name, surname, department)  value(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, surName);
            preparedStatement.setString(3, departments);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public List<Department> findAll(){
        List<Department> departmentList = new ArrayList<>();
        PreparedStatement p = null;
        try {
            p = this.connection.prepareStatement("SELECT * FROM user");
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
                departmentList.add( new Department(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return departmentList;
    }

    public void delete(int id) {
        PreparedStatement p = null;
        try {
            p = this.connection.prepareStatement("DELETE FROM user WHERE id = ?");
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Department findOne(int id) {
        Department department = null;
        PreparedStatement p = null;
        try {
            p = this.connection.prepareStatement("SELECT * FROM user WHERE id = ?");
            p.setInt(1, id);
            ResultSet resultSet = p.executeQuery();
            resultSet.next();
            department = new Department(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;

    }

    public void update(Integer id, String newname, String newsurname, String parameter) {
        PreparedStatement p = null;
        try {
            p = this.connection.prepareStatement("UPDATE user SET name=?, surname=?, department=? WHERE id=?");
            p.setString(1, newname);
            p.setString(2, newsurname);
            p.setString(3, parameter);
            p.setInt(4, id);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
