public class User {
    private int idUser;
    private String username;
    private String passwordHash;

    public boolean login(String username, String password) {
        return this.username != null
                && this.username.equals(username)
                && this.passwordHash != null
                && this.passwordHash.equals(password);
    }

    public void logout() {
        System.out.println("User " + this.username + " berhasil logout.");
    }

    public Email inputEmail(String isi) {
        Email emailBaru = new Email();
        if (isi != null && !isi.trim().isEmpty() && emailBaru.validasiInput()) {
            emailBaru.simpan();
            return emailBaru;
        }
        return null;
    }

    public HasilPrediksi lihatHasil(int idPrediksi) {
        HasilPrediksi hasil = new HasilPrediksi();
        if (idPrediksi > 0) {
            hasil.lihatDetailAnalisis();
            return hasil;
        }
        return null;
    }
}
