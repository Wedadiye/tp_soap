package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DbConnection;
import model.Employee;

public class EmployeeDao implements Dao<Employee> {
	// variables
	Connection connection = null;
	Statement statement = null;
	String requet = null;
	Employee Employee = null;

	public EmployeeDao() {
		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> getAll() {

		return null;
	}

	@Override
	public Employee getById(int id) {
		requet = "SELECT * FROM employee WHERE id =" + id + " ;";
		System.out.println(requet);
		try {
			ResultSet resultSet = statement.executeQuery(requet);
			resultSet.next();
			int id1= resultSet.getInt("id");
			String nom = resultSet.getString("nom");
			String email = resultSet.getString("email");
			String adress = resultSet.getString("adress");

			Employee = new Employee(id1, nom, email, adress);
			System.out.println(Employee.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Employee;
	}

	@Override
	public void save(Employee t) {
		requet = "insert into employee values(" + t.getId() + "," + t.getNom()+ ","+ t.getEmail()  + "," + t.getAdress() + ");";
		System.out.println(requet);

		try {
			int resultat = statement.executeUpdate(requet);
			if (resultat != 0) {
				System.out.println("Insertion effectuée");
			} else {
				System.out.println("Erreur d'insertion");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



    @Override
    public void update(Employee employee) {
        String query = "UPDATE employee SET nom = ? , email= ? ,adress= ?, WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getNom());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAdress());

            preparedStatement.setInt(4, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Employee employee ) {
        String query = "DELETE FROM employee WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
}
