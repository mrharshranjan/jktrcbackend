package net.jktrc.jktrcbackend.repository;

import net.jktrc.jktrcbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all CRUD database methods

}
