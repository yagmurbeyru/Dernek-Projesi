package com.yagmurbeyru.controller;

import java.util.List;

import com.yagmurbeyru.dto.DtoHaber;

public interface IUserHaberController {
	public List<DtoHaber> getAllHaber();
	public DtoHaber getHaberById(Integer id);

}
