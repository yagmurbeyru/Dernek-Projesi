package com.yagmurbeyru.services.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.yagmurbeyru.dto.DtoDuyuru;
import com.yagmurbeyru.entities.Duyuru;
import com.yagmurbeyru.exception.BaseException;
import com.yagmurbeyru.exception.ErrorMessage;
import com.yagmurbeyru.exception.MessageType;
import com.yagmurbeyru.repository.DuyuruRepository;
import com.yagmurbeyru.services.IDuyuruService;



@Service
public class DuyuruServiceImpl implements IDuyuruService {
    
    @Autowired
    private DuyuruRepository duyuruRepository;

    
    @Override
    public DtoDuyuru saveDuyuru(DtoDuyuru duyuru, MultipartFile file) {
        try {
            String filePath = null;

            // Dosya varsa yükle
            if (file != null && !file.isEmpty()) {
                String uploadDir = "uploads/duyurular/";

                // Klasör yoksa oluştur
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                

                // Benzersiz dosya adı
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path fullPath = uploadPath.resolve(fileName);

                // Dosyayı kaydet
                Files.write(fullPath, file.getBytes());

                // DB’ye kaydedilecek yol
                filePath = fullPath.toString();
            }

            // Entity oluştur
            Duyuru duyuruEntity = Duyuru.builder()
                    .konu(duyuru.getKonu())
                    .icerik(duyuru.getIcerik())
                    .gecerlilikTarihi(duyuru.getGecerlilikTarihi())
                    .resimYolu(filePath) // Dosya yolu null olabilir
                    .build();

            // DB’ye kaydet
            Duyuru saved = duyuruRepository.save(duyuruEntity);

            // DTO’ya dönüştür
            return DtoDuyuru.builder()
                    .id(saved.getId())
                    .konu(saved.getKonu())
                    .icerik(saved.getIcerik())
                    .gecerlilikTarihi(saved.getGecerlilikTarihi())
                    .resimYolu(saved.getResimYolu())
                    .build();

        } catch (Exception e) {
        	throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,""));
        }
    }


	
    @Override
    public DtoDuyuru updateDuyuru(Integer id, DtoDuyuru updatedduyuru, MultipartFile file) {
        // DB'den mevcut duyuruyu al
        Optional<Duyuru> optional = duyuruRepository.findById(id);

        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.ENTITY_NOT_FOUND, "id=" + id));
        }

        Duyuru dbDuyuru = optional.get();
        String filePath = dbDuyuru.getResimYolu(); // Varsayılan olarak eski resim yolunu al

        try {
            // Eğer yeni bir resim yüklenmişse dosyayı kaydet
            if (file != null && !file.isEmpty()) {
                String uploadDir = "uploads/duyurular/";
                Path uploadPath = Paths.get(uploadDir);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path fullPath = uploadPath.resolve(fileName);
                Files.write(fullPath, file.getBytes());

                filePath = fullPath.toString(); // Yeni resim yolu
            }
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.FILE_UPLOAD_ERROR, e.getMessage()));
        }

        // Güncellenmiş entity oluştur
        Duyuru updatedEntity = Duyuru.builder()
                .id(dbDuyuru.getId())
                .konu(updatedduyuru.getKonu())
                .icerik(updatedduyuru.getIcerik())
                .gecerlilikTarihi(updatedduyuru.getGecerlilikTarihi())
                .resimYolu(filePath)
                .build();

        Duyuru savedDuyuru = duyuruRepository.save(updatedEntity);

        // DTO’ya dönüştür ve return et
        return DtoDuyuru.builder()
                .id(savedDuyuru.getId())
                .konu(savedDuyuru.getKonu())
                .icerik(savedDuyuru.getIcerik())
                .gecerlilikTarihi(savedDuyuru.getGecerlilikTarihi())
                .resimYolu(savedDuyuru.getResimYolu())
                .build();
    }


	
	
	@Override
	public boolean deleteDuyuru(Integer id) {
		
		Optional<Duyuru> optional= duyuruRepository.findById(id);
		if (optional.isPresent()) {
			duyuruRepository.delete(optional.get());
			return true;
			
		}
		throw new BaseException(new ErrorMessage(MessageType.ENTITY_NOT_FOUND,""));
	}

	@Override
	public List<DtoDuyuru> getAllDuyuru() {
		List<Duyuru> duyuruList= duyuruRepository.findAll();
		List<DtoDuyuru>dtoList=new ArrayList<>();
		
		for (Duyuru duyuru : duyuruList) {
			DtoDuyuru dto=DtoDuyuru.builder()
					.id(duyuru.getId())
					.konu(duyuru.getKonu())
					.icerik(duyuru.getIcerik())
					.gecerlilikTarihi(duyuru.getGecerlilikTarihi())
					.resimYolu(duyuru.getResimYolu())
					.build();
			
			dtoList.add(dto);
			
			
		}
		return dtoList;
	}

	@Override
	public DtoDuyuru getDuyuruById(Integer id) {
		Optional<Duyuru> optional= duyuruRepository.findById(id);
		DtoDuyuru dto=null;
		if (optional.isPresent()) {
			Duyuru duyuru= optional.get();
			
			dto= DtoDuyuru.builder()
					.id(duyuru.getId())
					.konu(duyuru.getKonu())
					.icerik(duyuru.getIcerik())
					.gecerlilikTarihi(duyuru.getGecerlilikTarihi())
					.resimYolu(duyuru.getResimYolu())
					.build();
			
			
					
			return dto;
		}
		throw new BaseException(new ErrorMessage(MessageType.ENTITY_NOT_FOUND,""));
	}
	
	
	
	
	
	

}
