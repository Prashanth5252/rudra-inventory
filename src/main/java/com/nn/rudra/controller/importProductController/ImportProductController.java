package com.nn.rudra.controller.importProductController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/importproduct")
public class ImportProductController {

	@GetMapping("/getProductList")
	public Map<String, Object> getProductList(@RequestBody Map<String, Object> requestMap) {
		Map<String, Object> returnMap = new HashMap<>();
		try {
			returnMap.put("data", null);
			returnMap.put("status", true);
		} catch (Exception e) {
			returnMap.put("errorMessage", e.getMessage());
			returnMap.put("status", false);
		}
		return returnMap;
	}
}
