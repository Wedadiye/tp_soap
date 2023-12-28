package ServiceSOAP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Map;

import jakarta.jws.WebService;
import model.Employee;

@WebService(endpointInterface = "ServiceSOAP.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private Map<Integer, Employee> Employees = new HashMap<>();
    private int idCounter = 1;

    @Override
    public void addEmployee(Employee Employee) {
    	Employee.setId(idCounter++);
    	Employees.put(Employee.getId(), Employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return Employees.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(Employees.values());
    }

    @Override
    public void updateEmployee(Employee Employee) {
        if (Employees.containsKey(Employee.getId())) {
        	Employees.put(Employee.getId(), Employee);
        }
    }

    @Override
    public void deleteEmployee(int id) {
    	Employees.remove(id);
    }

	
}
