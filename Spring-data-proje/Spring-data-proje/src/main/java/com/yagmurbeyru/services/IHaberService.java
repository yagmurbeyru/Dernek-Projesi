package com.yagmurbeyru.services;

import java.util.List;

import com.yagmurbeyru.dto.DtoHaber;

public interface IHaberService {
	public DtoHaber saveHaber(DtoHaber haber);
	public DtoHaber updateHaber(Integer id, DtoHaber haber);
	public boolean deleteHaber(Integer id);
	public List<DtoHaber> getAllHaber();
	public DtoHaber getHaberById(Integer id);
	
	
}
