package net.jktrc.jktrcbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "data")
public class TestingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "material")
    private String material;
    @Column(name = "name_of_test")
    private String nameOfTest;
    @Column(name = "test_Performed_At")
    private String testPerformedAt;
    @Column(name = "status")
    private String status;

}
