package POSTTEST4;

import java.util.ArrayList;
import java.util.Scanner;

class Brand {
    private String namaBrand;
    private String kategori;
    private int tahunDidirikan;
    private String negaraAsal;

    public Brand(String namaBrand, String kategori, int tahunDidirikan, String negaraAsal) {
        this.namaBrand = namaBrand;
        this.kategori = kategori;
        this.tahunDidirikan = tahunDidirikan;
        this.negaraAsal = negaraAsal;
    }

    public String getNamaBrand() {
        return namaBrand;
    }

    public void setNamaBrand(String namaBrand) {
        this.namaBrand = namaBrand;
    }

    public String getKategori() {
        return kategori;
    }

    //setKategori Overload
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setKategori(String kategori, String keterangan) {
        this.kategori = kategori + " - " + keterangan;
    }

    public int getTahunDidirikan() {
        return tahunDidirikan;
    }

    public void setTahunDidirikan(int tahunDidirikan) {
        this.tahunDidirikan = tahunDidirikan;
    }

    public String getNegaraAsal() {
        return negaraAsal;
    }

    public void setNegaraAsal(String negaraAsal) {
        this.negaraAsal = negaraAsal;
    }

    //toString override
    @Override
    public String toString() {
        return "Nama Brand: " + namaBrand +
               "\nKategori: " + kategori +
               "\nTahun Didirikan: " + tahunDidirikan +
               "\nNegara Asal: " + negaraAsal;
    }
}

class LuxuryBrand extends Brand {
    private double hargaTertinggi;
    private String merkBrand;

    public LuxuryBrand(String namaBrand, String kategori, int tahunDidirikan, String negaraAsal, double hargaTertinggi, String merkBrand) {
        super(namaBrand, kategori, tahunDidirikan, negaraAsal);
        this.hargaTertinggi = hargaTertinggi;
        this.merkBrand = merkBrand;
    }

    public double getHargaTertinggi() {
        return hargaTertinggi;
    }

    public void setHargaTertinggi(double hargaTertinggi) {
        this.hargaTertinggi = hargaTertinggi;
    }

    public String getmerkBrand() {
        return merkBrand;
    }

    public void setmerkBrand(String merkBrand) {
        this.merkBrand = merkBrand;
    }

    // toString override
    @Override
    public String toString() {
        return super.toString() +
               "\nHarga Tertinggi: " + hargaTertinggi +
               "\nMerk Barang: " + merkBrand;
    }
}

class HypebeastBrand extends Brand {
    private ArrayList<String> kolaborasi;
    private double hargaResell;

    public HypebeastBrand(String namaBrand, String kategori, int tahunDidirikan, String negaraAsal, ArrayList<String> kolaborasi, double hargaResell) {
        super(namaBrand, kategori, tahunDidirikan, negaraAsal);
        this.kolaborasi = kolaborasi;
        this.hargaResell = hargaResell;
    }

    public ArrayList<String> getkolaborasi() {
        return kolaborasi;
    }

    public void setkolaborasi(ArrayList<String> kolaborasi) {
        this.kolaborasi = kolaborasi;
    }

    public double gethargaResell() {
        return hargaResell;
    }

    public void sethargaResell(double hargaResell) {
        this.hargaResell = hargaResell;
    }

    // toString override
    @Override
    public String toString() {
        return super.toString() +
               "\nHarga Resell: " + hargaResell +
               "\nKolaborasi: " + kolaborasi;
    }
}

public class brands {
    private static final ArrayList<Brand> brands = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        int pilihan;
        clearScreen();
        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    clearScreen();
                    tambahBrand();
                    break;
                case 2:
                    clearScreen();
                    tampilkanBrand();
                    break;
                case 3:
                    clearScreen();
                    ubahBrand();
                    break;
                case 4:
                    clearScreen();
                    hapusBrand();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void tambahBrand() {
        System.out.print("Masukkan nama brand: ");
        String namaBrand = scanner.next();
        System.out.print("Masukkan kategori (luxury/hypebeast): ");
        String kategori = scanner.next();
        System.out.print("Masukkan tahun didirikan: ");
        int tahunDidirikan = scanner.nextInt();
        System.out.print("Masukkan negara asal: ");
        String negaraAsal = scanner.next();
        
        if (kategori.equalsIgnoreCase("luxury")) {
            System.out.print("Masukkan harga tertinggi: ");
            double hargaTertinggi = scanner.nextDouble();
            System.out.print("Masukkan merk barang: ");
            String merkBarang = scanner.next();
            brands.add(new LuxuryBrand(namaBrand, kategori, tahunDidirikan, negaraAsal, hargaTertinggi, merkBarang));
        } else if (kategori.equalsIgnoreCase("hypebeast")) {
            System.out.print("Masukkan harga resell: ");
            double hargaResell = scanner.nextDouble();
            System.out.print("Masukkan jumlah kolaborasi: ");
            int jumlahKolaborasi = scanner.nextInt();
            ArrayList<String> kolaborasi = new ArrayList<>();
            for (int i = 0; i < jumlahKolaborasi; i++) {
                System.out.print("Masukkan nama kolaborasi ke-" + (i+1) + ": ");
                kolaborasi.add(scanner.next());
            }
            brands.add(new HypebeastBrand(namaBrand, kategori, tahunDidirikan, negaraAsal, kolaborasi, hargaResell));
        } else {
            System.out.println("Kategori tidak valid!");
        }
    
        System.out.println("Brand berhasil ditambahkan!");
        clearScreen();
    }

    private static void tampilkanMenu() {
        System.out.println("----- Sistem Pendataan Brand Luxury dan Hypebeast -----");
        System.out.println("1. Tambah Brand");
        System.out.println("2. Tampilkan Brand");
        System.out.println("3. Ubah Brand");
        System.out.println("4. Hapus Brand");
        System.out.println("5. Keluar");
        System.out.print("Masukkan pilihan: ");
    }

    private static void tampilkanBrand() {
        if (brands.isEmpty()) {
            System.out.println("Belum ada data brand.");
            return;
        }
    
        System.out.println("Daftar Brand:");
        for (int i = 0; i < brands.size(); i++) {
            System.out.println("Brand ke-" + (i + 1) + ":");
            System.out.println(brands.get(i)); // Memanggil metode toString() secara implisit
            System.out.println("--------------------------");
        }
    }
    

    private static void ubahBrand() {
        if (brands.isEmpty()) {
            System.out.println("Belum ada data brand!");
            return;
        }
        
        tampilkanBrand();
        System.out.print("Masukkan nomor indeks brand yang ingin diubah (Indeks di mulai dari 0.): ");
        int index = scanner.nextInt();
    
        if (index < 0 || index >= brands.size()) {
            System.out.println("Nomor indeks tidak valid!");
            return;
        }
    
        Brand brandYangAkanDiubah = brands.get(index);
    
        System.out.print("Masukkan nama brand baru: ");
        String namaBrandBaru = scanner.next();
        System.out.print("Masukkan kategori baru (luxury/hypebeast): ");
        String kategoriBaru = scanner.next();
        System.out.print("Masukkan tahun didirikan baru: ");
        int tahunDidirikanBaru = scanner.nextInt();
        System.out.print("Masukkan negara asal baru: ");
        String negaraAsalBaru = scanner.next();
    
        brandYangAkanDiubah.setNamaBrand(namaBrandBaru);
        brandYangAkanDiubah.setKategori(kategoriBaru);
        brandYangAkanDiubah.setTahunDidirikan(tahunDidirikanBaru);
        brandYangAkanDiubah.setNegaraAsal(negaraAsalBaru);
    
        System.out.println("Brand berhasil diubah!");
    }
    

    private static void hapusBrand() {
        if (brands.isEmpty()) {
            System.out.println("Belum ada data brand!");
            return;
        }
        System.out.print("Masukkan indeks brand yang ingin dihapus (Indeks di mulai dari 0.): ");
        int index = scanner.nextInt();
        brands.remove(index);
        System.out.println("Brand berhasil dihapus!");
    }
}