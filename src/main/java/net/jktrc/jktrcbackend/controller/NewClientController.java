package net.jktrc.jktrcbackend.controller;

import net.jktrc.jktrcbackend.exception.ResourceNotFoundException;
import net.jktrc.jktrcbackend.model.NewClient;
import net.jktrc.jktrcbackend.repository.NewClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/newClient")
public class NewClientController {

    @Autowired
    private NewClientRepository newClientRepository;

    @GetMapping
    public List<NewClient> getAllNewClient(){
        return newClientRepository.findAll();
    }

    //build or create New Client RestAPI
    @PostMapping
    public NewClient createNewClient(@RequestBody NewClient newClient){return newClientRepository.save(newClient);}

    //build get New Client by ID Rest API
    @GetMapping("{id}")
    public ResponseEntity<NewClient> getNewClientById(@PathVariable long id){
        NewClient newClient = newClientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client Not Found: "+ id));
        return ResponseEntity.ok(newClient);
    }

    //build update New Client Rest API
    @PutMapping("{id}")
    public ResponseEntity<NewClient> updateNewClient(@PathVariable long id,@RequestBody NewClient newClientDetails){
        NewClient updateNewClient = newClientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client does not exists: "+ id));

        updateNewClient.setFirstName(newClientDetails.getFirstName());
        updateNewClient.setLastName(newClientDetails.getLastName());
        updateNewClient.setEmailId(newClientDetails.getLastName());
        updateNewClient.setContactNumber(newClientDetails.getContactNumber());
        updateNewClient.setCompanyName(newClientDetails.getCompanyName());
        updateNewClient.setWorkArea(newClientDetails.getWorkArea());
        updateNewClient.setMaterialTest(newClientDetails.getMaterialTest());
        updateNewClient.setSpecifiedTest(newClientDetails.getSpecifiedTest());
        updateNewClient.setSampleName(newClientDetails.getSampleName());

        newClientRepository.save(updateNewClient);

        return ResponseEntity.ok(updateNewClient);
    }

    //build Delete New Client Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteNewClient(@PathVariable long id){
        NewClient newClient  = newClientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client Not Found with id: "+ id));

        newClientRepository.delete(newClient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
