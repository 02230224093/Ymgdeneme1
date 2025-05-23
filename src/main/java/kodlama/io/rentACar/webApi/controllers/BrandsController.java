package kodlama.io.rentACar.webApi.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;


@RestController //annotation
@RequestMapping ("/api/brands")

public class BrandsController {
  private BrandService brandService;
  
  
@Autowired
public BrandsController(BrandService brandService) {
	this.brandService = brandService;
}
  
@GetMapping ("/getAll")
public  List<GetAllBrandResponse> getAll() {
	return brandService.getAll();
}
 

@PostMapping("/add")
public void add(CreateBrandRequest createBrandRequest) {
	this.brandService.add(createBrandRequest);
}
}
