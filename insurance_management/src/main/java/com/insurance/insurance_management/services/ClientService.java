package com.insurance.insurance_management.services;

import java.util.List;
import java.util.Optional;

import com.insurance.insurance_management.entities.Client;

public interface ClientService {
	public List<Client> getAllClients();
	public Optional<Client> getClientById(Long id);
	public Client createClient(Client client);
	public Client updateClient(Long id, Client updatedClient);
	public int deleteClient(Long id);
}
