package com.example.omreon.model;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userlog")
public class ScUserlogController {
	
	@Autowired
	private ScUserlogService userlogService;
	
	@GetMapping("/all")
	public List<ScUserlog> getAll() {
		return userlogService.findAllList();
	}
	
	// Kullanmıyorum
	@GetMapping("/{id}")
	public ResponseEntity<ScUserlog> findById(@PathVariable Long id ) {
		
        Optional<ScUserlog> scUserlog = userlogService.findById(id);
        return ResponseEntity.ok(scUserlog.get());
    }
	// Güncelleme operasyonlarının çağırılması.
	@PutMapping(value = "/updateAll")
	public void executeUpdate() {
		userlogService.updateBatching();
	}
	
	
}


