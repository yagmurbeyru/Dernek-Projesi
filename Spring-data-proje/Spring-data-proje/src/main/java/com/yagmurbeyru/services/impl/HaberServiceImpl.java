package com.yagmurbeyru.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yagmurbeyru.dto.DtoHaber;
import com.yagmurbeyru.entities.Haber;
import com.yagmurbeyru.exception.BaseException;
import com.yagmurbeyru.exception.ErrorMessage;
import com.yagmurbeyru.exception.MessageType;
import com.yagmurbeyru.repository.HaberRepository;
import com.yagmurbeyru.services.IHaberService;



@Service
public class HaberServiceImpl implements IHaberService{
	
	@Autowired
	private HaberRepository haberRepository;

	@Override
	public DtoHaber saveHaber(DtoHaber haber) {
		Haber dbhaber= Haber.builder()
				.konu(haber.getKonu())
				.icerik(haber.getIcerik())
				.gecerlilikTarihi(haber.getGecerlilikTarihi())
				.haberLinki(haber.getHaberLinki())
				.build();
		
		Haber savedHaber= haberRepository.save(dbhaber);
		
		DtoHaber dto=DtoHaber.builder()
				.konu(savedHaber.getKonu())
				.icerik(savedHaber.getIcerik())
				.gecerlilikTarihi(savedHaber.getGecerlilikTarihi())
				.haberLinki(savedHaber.getHaberLinki())
				.build();
		return dto;
		
	}

	@Override
	public DtoHaber updateHaber(Integer id, DtoHaber haber) {
		Optional<Haber> optional= haberRepository.findById(id);
		if (optional.isPresent()) {
			Haber dbHaber=optional.get();
			Haber updatedHaber= Haber.builder()
					.id(dbHaber.getId())
					.konu(haber.getKonu())
					.icerik(haber.getIcerik()) 
					.gecerlilikTarihi(haber.getGecerlilikTarihi())
					.haberLinki(haber.getHaberLinki())
					.build();
			Haber savedHaber=haberRepository.save(updatedHaber);
			DtoHaber dto=DtoHaber.builder()
					.id(updatedHaber.getId())
					.konu(updatedHaber.getKonu())
					.icerik(updatedHaber.getIcerik()) 
					.gecerlilikTarihi(updatedHaber.getGecerlilikTarihi())
					.haberLinki(updatedHaber.getHaberLinki())
					.build();
			return dto;
			
		}
		throw new BaseException(new ErrorMessage(MessageType.ENTITY_NOT_FOUND,""));
	}

	@Override
	public boolean deleteHaber(Integer id) {
		Optional<Haber> optional= haberRepository.findById(id);
		if (optional.isPresent()) {
			haberRepository.delete(optional.get());
			return true;
			
		}
		throw new BaseException(new ErrorMessage(MessageType.ENTITY_NOT_FOUND,""));
		
	}

	@Override
	public List<DtoHaber> getAllHaber() {
		List<Haber> haberList= haberRepository.findAll();
		List<DtoHaber> dtoList=new ArrayList<>();
		
		DtoHaber dtoHaber=new DtoHaber();
		for (Haber haber : haberList) {
			DtoHaber dto=DtoHaber.builder()
					.id(haber.getId())
					.konu(haber.getKonu())
					.icerik(haber.getIcerik())
					.gecerlilikTarihi(haber.getGecerlilikTarihi())
					.haberLinki(haber.getHaberLinki())
					.build();
			
			dtoList.add(dto);
			
		}
		
		return dtoList;
	}

	@Override
	public DtoHaber getHaberById(Integer id) {
		Optional<Haber> optional= haberRepository.findById(id);
		DtoHaber dto = null;
	
		if (optional.isPresent()) {
			Haber haber= optional.get();
			
			dto=DtoHaber.builder()
					.id(haber.getId())
					.konu(haber.getKonu())
					.icerik(haber.getIcerik())
					.gecerlilikTarihi(haber.getGecerlilikTarihi())
					.haberLinki(haber.getHaberLinki())
					.build();
			return dto;
			
			
		}
		throw new BaseException(new ErrorMessage(MessageType.ENTITY_NOT_FOUND,""));
	}
	
	
	
	

}
