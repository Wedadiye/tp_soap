package ServiceClient;


import model.Employee;
import ServiceSOAP.EmployeeService;
import jakarta.xml.ws.Service;
import java.net.URL;

public class PersonServiceClient {
    public static void main(String[] args) {
        try {
            // Créez l'URL du service web
            URL url = new URL("http://localhost:8083/EmployeeService?wsdl");

            // Créez un objet Service à partir de l'URL et du nom du service
            Service service = Service.create(url, new javax.xml.namespace.QName("http://ServiceSOAP/", "EmployeeServiceImplService"));

            // Obtenez le port du service
            EmployeeService EmployeeService = service.getPort(EmployeeService.class);

            // Utilisez les méthodes exposées par le service web
            // Ajouter une personne
            Employee newEmployee= new Employee();

            newEmployee.setNom("fati");
            newEmployee.setEmail("fati@gmail.com");

            newEmployee.setAdress("dar barka");
            // Ajoutez la Employee en utilisant le service web
            EmployeeService.addEmployee(newEmployee);

            // Obtenez une Employee par son identifiant
            
            Employee retrievedEmployee = EmployeeService.getEmployee(14);
            
            System.out.println("Personne récupérée : " + retrievedEmployee.getId());

            // Obtenez toutes les Employees
            for (Employee Employee : EmployeeService.getAllEmployees()) {
                System.out.println("ID : " + Employee.getId() + ", Nom : " + Employee.getNom()  + ", Email : " + Employee.getEmail() + ", Adresse : " + Employee.getAdress());
            }

            // Mettez à jour une Employee existante
            //retrievedPerson.setId(3);
            //personService.updatePerson(retrievedPerson);

            // Supprimez une Employee
            //EmployeeService.deleteEmployee(8);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

