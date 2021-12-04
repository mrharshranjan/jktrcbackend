package net.jktrc.jktrcbackend.controller;

import lombok.Getter;
import net.jktrc.jktrcbackend.exception.ResourceNotFoundException;
import net.jktrc.jktrcbackend.model.TestingData;
import net.jktrc.jktrcbackend.repository.TestingDataRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/testingData")
public class TestingDataController {

    @Autowired
    private TestingDataRepository testingDataRepository;

    @GetMapping
    public List<TestingData> getAllTestingData(){
        return testingDataRepository.findAll();
    }
    @PostMapping
    public TestingData createTestingData(@RequestBody TestingData testingData){
        return testingDataRepository.save(testingData);
    }

    @GetMapping("{id}")
    public ResponseEntity<TestingData> getTestingDataById(@PathVariable long id){
        TestingData testingData = testingDataRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Data not found: "+ id));
        return ResponseEntity.ok(testingData);
    }

    @PutMapping("{id}")
    public ResponseEntity<TestingData> updateTestingData(@PathVariable long id, @RequestBody TestingData testingDataDetails){
        TestingData updateTestingData = testingDataRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Data does not exits: "+ id));

        updateTestingData.setMaterial(testingDataDetails.getMaterial());
        updateTestingData.setNameOfTest(testingDataDetails.getNameOfTest());
        updateTestingData.setTestPerformedAt(testingDataDetails.getTestPerformedAt());
        updateTestingData.setStatus(testingDataDetails.getStatus());

        testingDataRepository.save(updateTestingData);

        return ResponseEntity.ok(updateTestingData);
   }

   @DeleteMapping("{id}")
   public ResponseEntity<HttpStatus> deleteTestingData(@PathVariable long id){
        TestingData testingData = testingDataRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Data does not exists: "+ id));

        testingDataRepository.delete(testingData);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

}
