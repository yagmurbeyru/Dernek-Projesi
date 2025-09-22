package com.yagmurbeyru.controller;

import org.springframework.web.multipart.MultipartFile;
import com.yagmurbeyru.dto.DtoDuyuru;

public interface IAdminDuyuruController {
	public DtoDuyuru saveDuyuru(String duyuruJson, MultipartFile file);
    public DtoDuyuru updateDuyuru(Integer id, String DuyuruJson,MultipartFile file);
    public boolean deleteDuyuru(Integer id);
}
