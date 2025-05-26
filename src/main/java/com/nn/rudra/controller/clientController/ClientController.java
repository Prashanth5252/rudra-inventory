package com.nn.rudra.controller.clientController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nn.rudra.service.clientService.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientSercvice;

	@GetMapping("/getClients")
	public Map<String, Object> getClientList(@RequestBody Map<String, Object> paramMap) {
		Map<String, Object> returnMap = new HashMap<>();
		try {
			returnMap.put("data", clientSercvice.getClientList(paramMap));
			returnMap.put("status", true);
		} catch (Exception e) {
			returnMap.put("status", false);
			returnMap.put("errorMessage", e.getMessage());
		}
		return returnMap;
	}
	
	@GetMapping("/getClient")
	public Map<String, Object> getClient(@RequestBody Map<String, Object> paramMap) {
		Map<String, Object> returnMap = new HashMap<>();
		try {
			returnMap.put("data", null);
			returnMap.put("satus", true);
		} catch (Exception e) {
			returnMap.put("status", false);
			returnMap.put("errorMessage", e.getMessage());
		}
		return returnMap;
	}
	
	@PutMapping("/updateClient")
	public Map<String, Object> updateClient(@RequestBody Map<String, Object> paramMap) {
		Map<String, Object> returnMap = new HashMap<>();
		try {
			returnMap.putAll(clientSercvice.updateClient(paramMap));
			returnMap.put("status", true);
		} catch (Exception e) {
			returnMap.put("status", false);
			returnMap.put("errorMessage", e.getMessage());
		}
		return returnMap;
	}
}
