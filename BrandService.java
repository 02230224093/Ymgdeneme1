package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.responses.GetAllBrandResponse;



public interface BrandService {

	List<GetAllBrandResponse>getAll();
	void add(CreateBrandRequest createBrandRequest);
}
