package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.EnteDTO;
import service.EnteService;

@RestController
@RequestMapping("/ente")
public class EnteController {

	@Autowired 
	private EnteService enteService;
	
	@GetMapping
	public List<EnteDTO> getAllEnti(){
		return enteService.getAllEnti();
	}
}
