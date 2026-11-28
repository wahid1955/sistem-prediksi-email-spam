import java.time.LocalDateTime;

public class Email {
    private int idEmail;
    private String isiEmail;
    private LocalDateTime waktuInput;

    public boolean validasiInput() {
        return this.isiEmail != null && !this.isiEmail.trim().isEmpty();
    }

    public void simpan() {
        if (!validasiInput()) {
            throw new IllegalArgumentException("Isi email tidak boleh kosong.");
        }
        this.waktuInput = LocalDateTime.now();
        System.out.println("Email ID " + this.idEmail + " disimpan pada " + this.waktuInput);
    }
}
