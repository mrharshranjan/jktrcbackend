package net.jktrc.jktrcbackend.repository;

import net.jktrc.jktrcbackend.model.TestingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestingDataRepository extends JpaRepository<TestingData, Long> {
    //all CRUD operations
}
