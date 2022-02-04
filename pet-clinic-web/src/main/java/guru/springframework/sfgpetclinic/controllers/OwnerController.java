package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;
	
	//automatically autowired
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"","/", "/index", "/index.html"})
	public String listOwners(Model theModel) {
		
		theModel.addAttribute("owners", ownerService.findAll());
		
		return "owners/index";
	}
	
	@RequestMapping("/find")
	public String findOwners() {
		
		return "notimplemented";
	}
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		
		mav.addObject(ownerService.findById(ownerId));
		
		return mav;
	}
}
