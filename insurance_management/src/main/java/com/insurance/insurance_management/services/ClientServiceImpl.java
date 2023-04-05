package com.insurance.insurance_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.insurance.insurance_management.entities.Client;
import com.insurance.insurance_management.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	 @Autowired
	ClientRepository CR;

	@Override
	public List<Client> getAllClients() {
		return  CR.findAll();
	}

	@Override
	public Optional<Client> getClientById(Long id) {
		return CR.findById(id);
	}

	@Override
	public Client createClient(Client client) {
		Client alreadypresent;
		Long check = client.getId();
		Optional<Client> found=CR.findById(check);
		if(found.isPresent()==true) {
			return alreadypresent=null;
		}
		return CR.save(client);
	}

	@Override
	public Client updateClient(Long id, Client updatedClient) {
		 Optional<Client> existingClient = CR.findById(id);
		 Client notfound=null;
		 
		 Long changeid = updatedClient.getId();
			
			if(changeid!=id) {
				return notfound;
			}
		 
		 if (existingClient.isPresent()) {
	            Client client = existingClient.get();
	            client.setName(updatedClient.getName());
	            client.setDateOfBirth(updatedClient.getDateOfBirth());
	            client.setAddress(updatedClient.getAddress());
	            client.setPhno(updatedClient.getPhno());
	            client.setEmail(updatedClient.getEmail());
	            CR.save(client);
	            return updatedClient;
		 }
		 else {
			 return notfound; 
		 }
	}
	
	@Override
	 public int deleteClient(@PathVariable Long id) {
		int deleteupdate=0;
		Optional<Client> client = CR.findById(id);
		if (client.isPresent()) {
            CR.delete(client.get());
            deleteupdate=1;
        }
		return deleteupdate; 
	}	
}