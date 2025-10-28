package com.sarah.penggunaanservice.service;

import com.sarah.penggunaanservice.model.Penggunaan;
import com.sarah.penggunaanservice.repository.PenggunaanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PenggunaanService {
    @Autowired
    private PenggunaanRepository PenggunaanRepository;

    public Penggunaan createPenggunaan(Penggunaan Penggunaan) {
        return PenggunaanRepository.save(Penggunaan);
    }

    public List<Penggunaan> getAllPenggunaan() {
        return PenggunaanRepository.findAll();
    }

    public Optional<Penggunaan> getPenggunaanById(Long id) {
        return PenggunaanRepository.findById(id);
    }

    public Penggunaan updatePenggunaan(Long id, Penggunaan PenggunaanDetails) {
        return PenggunaanRepository.save(PenggunaanDetails);
    }

    public void deletePenggunaan(Long id) {
        if (!PenggunaanRepository.existsById(id)) {
            throw new RuntimeException("Penggunaan tidak ditemukan dengan id: " + id);
        }
        PenggunaanRepository.deleteById(id);
    }

     

}

