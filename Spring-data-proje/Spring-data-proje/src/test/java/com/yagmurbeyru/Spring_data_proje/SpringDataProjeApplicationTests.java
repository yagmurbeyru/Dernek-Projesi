package com.yagmurbeyru.Spring_data_proje;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.yagmurbeyru.dto.DtoHaber;
import com.yagmurbeyru.services.IDuyuruService;
import com.yagmurbeyru.services.IHaberService;
import com.yagmurbeyru.starter.SpringDataProjeApplication;

@SpringBootTest(classes = {SpringDataProjeApplication.class})

class SpringDataProjeApplicationTests {

	@Autowired
	private IDuyuruService duyuruService;
	
	@Autowired
	private IHaberService haberService;
	
	@Test
	public void testgetHaberById() {
		DtoHaber dtoHaber= haberService.getHaberById(5);
		assertEquals(dtoHaber.getKonu(), "sıcaklık");
		
	}
	@Test
	public void testdeleteDuyuru () {
		boolean deleteHaber = haberService.deleteHaber(5);
		assertEquals(deleteHaber, true);
		
	}
	@Test
	public void testgetAllHaber(){
		List<DtoHaber> allHaber = haberService.getAllHaber();
		assertNotNull(allHaber);
	}
	


	

	
}
