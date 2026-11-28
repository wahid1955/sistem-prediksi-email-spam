import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessing {

    public String cleaning(String teks) {
        if (teks == null) {
            return "";
        }
        return teks.toLowerCase()
                   .replaceAll("[^a-z0-9\\s]", " ")
                   .replaceAll("\\s+", " ")
                   .trim();
    }

    public List<String> tokenizing(String teks) {
        if (teks == null || teks.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(teks.split(" ")));
    }

    public List<String> stemming(List<String> token) {
        List<String> hasilStemming = new ArrayList<>();
        for (String kata : token) {
            String kataDasar = kata.replaceFirst("^(me|ber|ter|di|ke|se)", "")
                                   .replaceFirst("(kan|an|i)$", "");
            hasilStemming.add(kataDasar.isEmpty() ? kata : kataDasar);
        }
        return hasilStemming;
    }

    public List<String> proses(String teks) {
        String teksBersih = cleaning(teks);
        List<String> daftarToken = tokenizing(teksBersih);
        return stemming(daftarToken);
    }
}
