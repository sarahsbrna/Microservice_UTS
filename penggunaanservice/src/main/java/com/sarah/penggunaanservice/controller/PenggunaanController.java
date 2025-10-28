package com.sarah.penggunaanservice.controller;

import com.sarah.penggunaanservice.DTO.PenggunaanRequestDTO;
import com.sarah.penggunaanservice.model.Penggunaan;
import com.sarah.penggunaanservice.service.PenggunaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penggunaan")
public class PenggunaanController {

    @Autowired
    private PenggunaanService penggunaanService;

    // Helper: Konversi DTO → Entity
    private Penggunaan convertToEntity(PenggunaanRequestDTO dto) {
        Penggunaan penggunaan = new Penggunaan();
        penggunaan.setKd_transaksi(dto.getKd_transaksi());
        penggunaan.setPelanggan(dto.getPelanggan());
        penggunaan.setMeterbulanini(dto.getMeterbulanini());
        penggunaan.setMeterbulanlalu(dto.getMeterbulanlalu());
        penggunaan.setTarifpermeter(dto.getTarifpermeter());

        // Ambil hasil hitung dari DTO
        penggunaan.setPemakaian(dto.getPemakaian());
        penggunaan.setTotal(dto.getTotal());

        return penggunaan;
    }

    @PostMapping
    public ResponseEntity<Penggunaan> createPenggunaan(@RequestBody PenggunaanRequestDTO dto) {
        // Validasi dasar
        if (dto.getMeterbulanini() < dto.getMeterbulanlalu()) {
            return ResponseEntity.badRequest().build(); // atau kirim error message
        }
        Penggunaan entity = convertToEntity(dto);
        Penggunaan saved = penggunaanService.createPenggunaan(entity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Penggunaan> getAllPenggunaan() {
        return penggunaanService.getAllPenggunaan();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Penggunaan> getPenggunaanById(@PathVariable Long id) {
        return penggunaanService.getPenggunaanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Penggunaan> updatePenggunaan(@PathVariable Long id, @RequestBody PenggunaanRequestDTO dto) {
        if (dto.getMeterbulanini() < dto.getMeterbulanlalu()) {
            return ResponseEntity.badRequest().build();
        }
        Penggunaan entity = convertToEntity(dto);
        entity.setId(id);
        try {
            Penggunaan updated = penggunaanService.updatePenggunaan(id, entity);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePenggunaan(@PathVariable Long id) {
        penggunaanService.deletePenggunaan(id);
        return ResponseEntity.noContent().build();
    }
}