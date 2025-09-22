package com.yagmurbeyru.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yagmurbeyru.controller.IAdminHaberController;
import com.yagmurbeyru.dto.DtoHaber;
import com.yagmurbeyru.services.IHaberService;

@RestController
@RequestMapping("/rest/api/adminhaber")


public class AdminHaberControllerImpl implements IAdminHaberController{
	
	@Autowired
	private IHaberService haberService;

	@PostMapping("/save")
	@Override
	public DtoHaber saveHaber(@RequestBody DtoHaber haber) {
		return haberService.saveHaber(haber);
		
	}
	@PutMapping("/update/{id}")
	@Override
	public DtoHaber updateHaber(@PathVariable(name="id") Integer id,@RequestBody DtoHaber haber) {
		return haberService.updateHaber(id, haber);
	}
	@DeleteMapping("/delete/{id}")
	@Override
	public boolean deleteHaber(@PathVariable(name = "id") Integer id) {
		return haberService.deleteHaber(id);
	}
	
	

}
