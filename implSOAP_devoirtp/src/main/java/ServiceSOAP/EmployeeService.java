package ServiceSOAP;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import model.Employee;

@WebService
public interface EmployeeService {

    @WebMethod
    void addEmployee(Employee Employee);

    @WebMethod
    Employee getEmployee(int id);

    @WebMethod
    List<Employee> getAllEmployees();

    @WebMethod
    void updateEmployee(Employee Employee);

    @WebMethod
    void deleteEmployee(int id);
}
