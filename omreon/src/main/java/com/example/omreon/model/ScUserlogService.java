package com.example.omreon.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScUserlogService {
	

	@Autowired
	private ScUserlogRepository userRepository;
	
	@Autowired
	public ScUserlogService(ScUserlogRepository userRepository) {
		this.userRepository = userRepository;
	}
	// Liste halinde bütün scUserlogların bulunması
	public List<ScUserlog> findAllList()
	{
		List<ScUserlog> scUsers = new ArrayList<ScUserlog>();
		userRepository.findAll().forEach(scUsers::add);
		return scUsers;

	}
	
	public Iterable<ScUserlog> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<ScUserlog> findById(Long id) {
		return userRepository.findById(id);
	}
	// ScUserlog save işlemi
	public ScUserlog save(ScUserlog scUserlog) {
		return userRepository.save(scUserlog);
	}
	//Liste halindeli scUserlogları alıp güncelleme operasyonlarının yapılması
	public boolean updateBatching() {
		List<ScUserlog>  scUserlogList = findAllList();
	
		for (ScUserlog scUserlog : scUserlogList) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			 cal.add(Calendar.DATE, - (int) scUserlog.getDbId()/14400);
			 Date forAdd = cal.getTime();
			 scUserlog.setLogTime(forAdd);	
			 userRepository.save(scUserlog);
			 userRepository.flush();
			 
		}		
		return true;
	}
	
	
	
	
}


