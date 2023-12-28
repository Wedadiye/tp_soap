package ServiceSOAP;

import jakarta.xml.ws.Endpoint;

public class ServicePublisher1 {
    public static void main(String[] args) {
        System.setProperty("javax.xml.bind.JAXBContextFactory", "com.sun.xml.bind.v2.ContextFactory");
        String url = "http://localhost:8083/EmployeeService";
        Endpoint.publish(url, new EmployeeServiceImpl());
        System.out.println("Service web CRUD publié avec succès à l'adresse : " + url);
    }
}
