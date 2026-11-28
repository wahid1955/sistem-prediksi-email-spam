public class DataEmailTraining {
    private int idData;
    private String isiEmail;
    private String label;

    public boolean validasiData() {
        boolean isiValid = this.isiEmail != null && !this.isiEmail.trim().isEmpty();
        boolean labelValid = "Spam".equalsIgnoreCase(this.label)
                          || "Ham".equalsIgnoreCase(this.label);
        return isiValid && labelValid;
    }

    public void tambah() {
        if (!validasiData()) {
            throw new IllegalArgumentException("Data training tidak valid.");
        }
        System.out.println("Data training ID " + this.idData + " ditambahkan.");
    }

    public void ubah(String isi, String label) {
        this.isiEmail = isi;
        this.label = label;
        if (validasiData()) {
            System.out.println("Data training ID " + this.idData + " diperbarui.");
        }
    }

    public void hapus() {
        System.out.println("Data training ID " + this.idData + " dihapus.");
    }
}
