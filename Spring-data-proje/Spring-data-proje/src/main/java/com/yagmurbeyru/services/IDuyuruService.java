package com.yagmurbeyru.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yagmurbeyru.dto.DtoDuyuru;


public interface IDuyuruService {
	public DtoDuyuru saveDuyuru(DtoDuyuru duyuru,MultipartFile file);
	public DtoDuyuru updateDuyuru(Integer id, DtoDuyuru updatedduyuru, MultipartFile file);
	public boolean deleteDuyuru (Integer id);
	public List<DtoDuyuru> getAllDuyuru();
	public DtoDuyuru getDuyuruById(Integer id);
}
