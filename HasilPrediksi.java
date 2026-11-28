import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HasilPrediksi {
    private int idPrediksi;
    private String kelas;
    private float probabilitasSpam;
    private float probabilitasHam;
    private String teksTerproses;
    private LocalDateTime waktuPrediksi;

    public void simpan() {
        this.waktuPrediksi = LocalDateTime.now();
        System.out.println("Hasil prediksi ID " + this.idPrediksi
                + " (" + this.kelas + ") disimpan pada " + this.waktuPrediksi);
    }

    public String lihatDetailAnalisis() {
        return "Kelas: " + this.kelas
                + " | Teks Terproses: [" + this.teksTerproses + "]"
                + " | Spam: " + (this.probabilitasSpam * 100) + "%"
                + " | Ham: " + (this.probabilitasHam * 100) + "%";
    }

    public Map<String, Float> lihatProbabilitas() {
        Map<String, Float> probabilitas = new HashMap<>();
        probabilitas.put("Spam", this.probabilitasSpam);
        probabilitas.put("Ham", this.probabilitasHam);
        return probabilitas;
    }
}
