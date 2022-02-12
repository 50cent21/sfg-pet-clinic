package guru.springframework.sfgpetclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;

@Controller
public class VetController {

	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({"/vets", "/vets/index", "vets/index.html", "/vets.html"})
	public String listVets(Model theModel) {
		
		theModel.addAttribute("vets", vetService.findAll());
		
		return "vets/index";
	}
	
	@RequestMapping("/api/vets")
	public @ResponseBody Set<Vet> getVetsJson() {
		
		
		return vetService.findAll();
	}
}
