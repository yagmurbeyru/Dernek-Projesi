package com.yagmurbeyru.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yagmurbeyru.controller.IUserDuyuruController;
import com.yagmurbeyru.dto.DtoDuyuru;
import com.yagmurbeyru.services.IDuyuruService;

@RestController
@RequestMapping("rest/api/userDuyuru")


public class UserDuyuruControllerImpl implements IUserDuyuruController{
	
	@Autowired
	private IDuyuruService duyuruService;

	@GetMapping("list")
	@Override
	public List<DtoDuyuru> getAllDuyuru() {
		return duyuruService.getAllDuyuru();
	}

	@GetMapping("list/{id}")
	@Override
	public DtoDuyuru getDuyuruById(@PathVariable(name = "id") Integer id) {
		return duyuruService.getDuyuruById(id);
	}
	
	

}
