package br.com.teste.challenge.controller;

import br.com.teste.challenge.repository.BrandRepository;
import br.com.teste.challenge.service.BrandService;
import br.com.teste.challenge.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/listBrands")
	public String listBrands(Model model) {
		model.addAttribute("listBrands", carService.sortListOfCars(brandRepository.findByOrderByNameDesc()));
		return "listBrands";
	}
	
	@RequestMapping("/createCars")
	public String createCars() {
		return "createCars";
	}
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	public String save(@RequestParam("name") String name, @RequestParam("mark") String mark) {
		brandService.save(name, mark);
		return "createCars";
	}
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public String delete(@RequestParam("name") String nameCar, Model model) {
		brandService.delete(nameCar);
		return listBrands(model);
	}
}
