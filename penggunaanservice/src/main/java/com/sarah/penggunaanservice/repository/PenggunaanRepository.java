package com.sarah.penggunaanservice.repository;

import com.sarah.penggunaanservice.model.Penggunaan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenggunaanRepository extends JpaRepository<Penggunaan, Long> {
}