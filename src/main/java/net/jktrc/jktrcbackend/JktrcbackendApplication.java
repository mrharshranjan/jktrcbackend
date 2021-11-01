package net.jktrc.jktrcbackend;

import net.jktrc.jktrcbackend.model.Employee;
import net.jktrc.jktrcbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JktrcbackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JktrcbackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

//		Employee employee = new Employee();
//		employee.setFirstName("Ram");
//		employee.setLastName("Sharma");
//		employee.setEmailId("ramsharma@gmail.com");
//		employeeRepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Shyam");
//		employee1.setLastName("Sharma");
//		employee1.setEmailId("shyamsharma@gmail.com");
//		employeeRepository.save(employee1);

	}
}
