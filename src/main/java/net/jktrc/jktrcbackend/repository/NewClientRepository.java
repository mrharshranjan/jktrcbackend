package net.jktrc.jktrcbackend.repository;

import net.jktrc.jktrcbackend.model.NewClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewClientRepository extends JpaRepository<NewClient, Long> {
    //all CRUD Operations
}
