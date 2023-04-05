package com.insurance.insurance_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.insurance_management.entities.Client;
import com.insurance.insurance_management.services.ClientService;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService CS;

    // GET /api/clients: Fetch all clients
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
    	List<Client> AllClients = this.CS.getAllClients() ;
    	if(AllClients.size()<=0) {
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}
        return ResponseEntity.of(Optional.of(AllClients));
    }
    
 // GET /api/clients/{id}: Fetch a specific client by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id) {
    	 Optional<Client> clientbyid = this.CS.getClientById(id);
    	 if(clientbyid.isPresent()==false) {
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	 }
    	 return ResponseEntity.of(Optional.of(clientbyid));
    }
    
 // POST /api/clients{id}: Create a new client
    @PostMapping
    public  ResponseEntity<Client> createClient(@Validated @RequestBody Client client) {
    	try {
    		Client C = this.CS.createClient(client);
    		if(C==null) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    		}
    		
    		return ResponseEntity.of(Optional.of(C));
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
    
 // PUT /api/clients: update client
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id,@Validated @RequestBody Client updatedClient) {
    	try {
    		Client update =  this.CS.updateClient(id,updatedClient);
        	if(update==null) {
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	}
        	else {
        		return  ResponseEntity.of(Optional.of(update));
        	}
    	}
    	catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
    
 // DELETE /api/clients{id}: delete client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    	try {
    		int deleteupdate=this.CS.deleteClient(id);
        	if(deleteupdate==1) {
        		return ResponseEntity.status(HttpStatus.OK).build();
        	}
        	else {
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
    }
}



