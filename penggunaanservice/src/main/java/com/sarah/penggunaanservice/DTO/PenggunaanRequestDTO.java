package com.sarah.penggunaanservice.DTO;

// import com.sarah.penggunaanservice.model.Penggunaan;

public class PenggunaanRequestDTO {
    private String kd_transaksi;
    private String pelanggan;
    private double meterbulanini;
    private double meterbulanlalu;
    private double tarifpermeter;

    public String getKd_transaksi() {
        return kd_transaksi;
    }

    public void setKd_transaksi(String kd_transaksi) {
        this.kd_transaksi = kd_transaksi;
    }

    public String getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(String pelanggan) {
        this.pelanggan = pelanggan;
    }

    public double getMeterbulanini() {
        return meterbulanini;
    }

    public void setMeterbulanini(double meterbulanini) {
        this.meterbulanini = meterbulanini;
    }

    public double getMeterbulanlalu() {
        return meterbulanlalu;
    }

    public void setMeterbulanlalu(double meterbulanlalu) {
        this.meterbulanlalu = meterbulanlalu;
    }

    public double getTarifpermeter() {
        return tarifpermeter;
    }

    public void setTarifpermeter(double tarifpermeter) {
        this.tarifpermeter = tarifpermeter;
    }

    public double getPemakaian() {
        if (this.meterbulanini < this.meterbulanlalu) {
            return 0;
        }
        return this.meterbulanini - this.meterbulanlalu;
    }

    public double getTotal() {
        return getPemakaian() * this.tarifpermeter;
    }

}
