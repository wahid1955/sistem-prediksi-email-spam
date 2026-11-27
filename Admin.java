import java.time.LocalDate;

public class Admin extends User {

    public void tambahData(String isi, String label) {
        DataEmailTraining data = new DataEmailTraining();
        if (isi != null && label != null && data.validasiData()) {
            data.tambah();
        }
    }

    public void ubahData(int idData, String isi, String label) {
        DataEmailTraining data = new DataEmailTraining();
        if (idData > 0) {
            data.ubah(isi, label);
        }
    }

    public void hapusData(int idData) {
        DataEmailTraining data = new DataEmailTraining();
        if (idData > 0) {
            data.hapus();
        }
    }

    public ModelNaiveBayes latihModel() {
        ModelNaiveBayes model = new ModelNaiveBayes();
        model.aktifkan();
        return model;
    }

    public void kelolaModel(int idModel, String aksi) {
        ModelNaiveBayes model = new ModelNaiveBayes();
        if (idModel > 0 && "aktifkan".equalsIgnoreCase(aksi)) {
            model.aktifkan();
        } else if (idModel > 0 && "nonaktifkan".equalsIgnoreCase(aksi)) {
            model.nonaktifkan();
        }
    }

    public LaporanPrediksi lihatLaporan(LocalDate awal, LocalDate akhir) {
        LaporanPrediksi laporan = new LaporanPrediksi();
        laporan.ambilData(awal, akhir);
        laporan.hitungRingkasan();
        return laporan;
    }
}
