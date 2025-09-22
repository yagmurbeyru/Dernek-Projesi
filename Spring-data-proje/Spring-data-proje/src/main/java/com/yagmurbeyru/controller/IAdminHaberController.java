package com.yagmurbeyru.controller;

import com.yagmurbeyru.dto.DtoHaber;

public interface IAdminHaberController {
	public DtoHaber saveHaber(DtoHaber haber);
	public DtoHaber updateHaber(Integer id, DtoHaber haber);
	public boolean deleteHaber(Integer id);

}
