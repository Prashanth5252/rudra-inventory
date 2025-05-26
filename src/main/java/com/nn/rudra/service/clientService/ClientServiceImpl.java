package com.nn.rudra.service.clientService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nn.rudra.entity.clientEntity.Client;
import com.nn.rudra.repo.clientRepository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepositroy;
	
	@Override
	public List<Client> getClientList(Map<String, Object> paramMap) throws Exception {
		int offset = Integer.parseInt(Objects.toString(paramMap.getOrDefault("offset", 0)));
		Sort sort = Sort.by("DEsc", "client_name");
		Pageable page = PageRequest.of(offset, 10, sort);
		List<Client> clientList = clientRepositroy.findAll(page).toList();
		return clientList;
	}

	@Override
	public Client getClient(Map<String, Object> paramMap) throws Exception {
		String clientId = paramMap.getOrDefault("clientId", "").toString();
		return clientRepositroy.getById(clientId);
	}

	@Override
	public Map<String, Object> updateClient(Map<String, Object> paramMap) throws Exception {
		String clientId = paramMap.getOrDefault("clientId", "").toString();
		String clientName = paramMap.getOrDefault("clientName", "").toString();
		long phoneNumber = (long) paramMap.getOrDefault("phoneNumber", 0);
		String address = paramMap.getOrDefault("address", "").toString();
		Client client = new Client(clientId, clientName, phoneNumber, address);
		clientRepositroy.save(client);
		return Map.of("affectedRows", 1);
	}
	
	
	

}
