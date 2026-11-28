import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelNaiveBayes {
    private int idModel;
    private String versi;
    private LocalDateTime tanggalTraining;
    private String status;
    private Map<String, Double> paramaterModel;

    public void latih(List<DataEmailTraining> data) {
        this.paramaterModel = new HashMap<>();
        int totalData = (data != null) ? data.size() : 0;
        this.paramaterModel.put("total_data", (double) totalData);
        this.tanggalTraining = LocalDateTime.now();
        this.status = "Aktif";
    }

    public Map<String, Float> hitungprobabilitas(List<String> token) {
        Map<String, Float> hasilProb = new HashMap<>();
        double prior = (this.paramaterModel != null)
                ? this.paramaterModel.getOrDefault("prior_spam", 0.5) : 0.5;
        float probSpam = (float) prior;
        float probHam = 1.0f - probSpam;
        hasilProb.put("Spam", probSpam);
        hasilProb.put("Ham", probHam);
        return hasilProb;
    }

    public HasilPrediksi prediksi(Email email) {
        Preprocessing prep = new Preprocessing();
        List<String> tokens = prep.proses(email != null ? email.toString() : "");
        Map<String, Float> prob = hitungprobabilitas(tokens);
        HasilPrediksi hasil = new HasilPrediksi();
        hasil.simpan();
        return hasil;
    }

    public void aktifkan() {
        this.status = "Aktif";
    }

    public void nonaktifkan() {
        this.status = "Nonaktif";
    }
}
