package com.yagmurbeyru.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yagmurbeyru.controller.IUserHaberController;
import com.yagmurbeyru.dto.DtoHaber;
import com.yagmurbeyru.services.IHaberService;

@RestController
@RequestMapping("rest/api/userHaber")


public class UserHaberControllerImpl implements IUserHaberController{
	
	@Autowired
	private IHaberService haberService;

	@GetMapping("/list")
	@Override
	public List<DtoHaber> getAllHaber() {
		return haberService.getAllHaber();
	}

	@GetMapping("/list/{id}")
	@Override
	public DtoHaber getHaberById(@PathVariable (name = "id") Integer id) {
		return haberService.getHaberById(id);
	}
	


}
