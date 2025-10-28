package com.sarah.penggunaanservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "penggunaans")

public class Penggunaan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kd_transaksi;
    private String pelanggan;
    private double meterbulanini;
    private double meterbulanlalu;
    private double pemakaian;
    private double tarifpermeter;
    private double total;

}
