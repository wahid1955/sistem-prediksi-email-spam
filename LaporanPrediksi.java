import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LaporanPrediksi {
    private LocalDate tanggalAwal;
    private LocalDate tanggalAkhir;
    private int totalSpam;
    private int totalHam;

    public List<HasilPrediksi> ambilData(LocalDate awal, LocalDate akhir) {
        this.tanggalAwal = awal;
        this.tanggalAkhir = akhir;
        List<HasilPrediksi> hasil = new ArrayList<>();
        System.out.println("Mengambil data prediksi dari "
                + this.tanggalAwal + " s.d. " + this.tanggalAkhir);
        return hasil;
    }

    public void hitungRingkasan() {
        List<HasilPrediksi> daftar = ambilData(this.tanggalAwal, this.tanggalAkhir);
        this.totalSpam = 0;
        this.totalHam = 0;
        for (HasilPrediksi item : daftar) {
            this.totalSpam++;
        }
    }

    public HasilPrediksi lihatDetail(int idPrediksi) {
        if (idPrediksi > 0) {
            HasilPrediksi detail = new HasilPrediksi();
            detail.lihatDetailAnalisis();
            return detail;
        }
        return null;
    }
}
