package com.mmaliga.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmaliga.dto.FighterDTO;
import com.mmaliga.services.FighterService;

@RestController
@RequestMapping(value = "/fighters")
public class FighterResource {

	@Autowired
	private FighterService fighterService;
	
	
    @GetMapping
    public ResponseEntity<List<FighterDTO>> findAll() {
    	List<FighterDTO> page = fighterService.findAll();
        return ResponseEntity.ok().body(page);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<FighterDTO> findById(@PathVariable long id) throws Exception {
    	FighterDTO dto = fighterService.findById(id);
        return ResponseEntity.ok().body(dto);
    }
	
}
