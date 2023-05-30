package com.udistrital.app.controllers;

import com.udistrital.app.entity.dto.RegionDTO;
import com.udistrital.app.services.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/regiones")
public class RegionController {

    final private RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RegionDTO>> getRegiones() {
        return ResponseEntity.ok(regionService.getRegiones());
    }

}
