package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.BandoDTO;
import service.BandoService;

@RestController
@RequestMapping("/api/bandi")
public class BandoController {

	@Autowired
	private BandoService bandoService;
	
	
	@GetMapping
	public List<BandoDTO> getAllBandi(){
		return this.bandoService.getAllBandi();
	}
}
