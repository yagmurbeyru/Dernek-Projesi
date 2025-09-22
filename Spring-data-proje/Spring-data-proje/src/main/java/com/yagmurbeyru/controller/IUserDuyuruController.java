package com.yagmurbeyru.controller;

import java.util.List;

import com.yagmurbeyru.dto.DtoDuyuru;

public interface IUserDuyuruController {
	public List<DtoDuyuru> getAllDuyuru();
	public DtoDuyuru getDuyuruById(Integer id);

}
