package com.nn.rudra.service.clientService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nn.rudra.entity.clientEntity.Client;

@Service
public interface ClientService {

	public List<Client> getClientList(Map<String, Object> paramMap) throws Exception;
	
	public Client getClient(Map<String, Object> paramMap) throws Exception;
	
	public Map<String, Object> updateClient(Map<String, Object> paramMap) throws Exception;
	
	
	}
