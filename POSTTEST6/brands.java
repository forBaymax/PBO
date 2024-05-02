package POSTTEST6;

import java.util.ArrayList;
import java.util.Scanner;

// Interface
interface Displayable {
    void displayInfo();
    void displayType();
}

abstract class Brand {
    private final String namaBrand;
    private final String kategori;
    private final int tahunDidirikan;
    private final String negaraAsal;

    public Brand(String namaBrand, String kategori, int tahunDidirikan, String negaraAsal) {
        this.namaBrand = namaBrand;
        this.kategori = kategori;
        this.tahunDidirikan = tahunDidirikan;
        this.negaraAsal = negaraAsal;
    }

    public final String getNamaBrand() {
        return namaBrand;
    }

    public final String getKategori() {
        return kategori;
    }

    public final int getTahunDidirikan() {
        return tahunDidirikan;
    }

    public final String getNegaraAsal() {
        return negaraAsal;
    }

    public abstract void displayInfo();

    @Override
    public String toString() {
        return "Nama Brand: " + namaBrand +
               "\nKategori: " + kategori +
               "\nTahun Didirikan: " + tahunDidirikan +
               "\nNegara Asal: " + negaraAsal;
    }
}

class LuxuryBrand extends Brand {
    private final double hargaTertinggi;
    private final String merkBrand;

    public LuxuryBrand(String namaBrand, String kategori, int tahunDidirikan, String negaraAsal, double hargaTertinggi, String merkBrand) {
        super(namaBrand, kategori, tahunDidirikan, negaraAsal);
        this.hargaTertinggi = hargaTertinggi;
        this.merkBrand = merkBrand;
    }

    public double getHargaTertinggi() {
        return hargaTertinggi;
    }

    public String getMerkBrand() {
        return merkBrand;
    }

    @Override
    public final void displayInfo() {
        System.out.println("Nama Brand: " + getNamaBrand() +
                "\nKategori: " + getKategori() +
                "\nTahun Didirikan: " + getTahunDidirikan() +
                "\nNegara Asal: " + getNegaraAsal() +
                "\nHarga Tertinggi: " + getHargaTertinggi() +
                "\nMerk Barang: " + getMerkBrand());
    }

    public void displayType() {
        System.out.println("Luxury Brand");
    }
}

class HypebeastBrand extends Brand {
    private final ArrayList<String> kolaborasi;
    private final double hargaResell;

    public HypebeastBrand(String namaBrand, String kategori, int tahunDidirikan, String negaraAsal, ArrayList<String> kolaborasi, double hargaResell) {
        super(namaBrand, kategori, tahunDidirikan, negaraAsal);
        this.kolaborasi = kolaborasi;
        this.hargaResell = hargaResell;
    }

    public ArrayList<String> getKolaborasi() {
        return kolaborasi;
    }

    public double getHargaResell() {
        return hargaResell;
    }

    @Override
    public final void displayInfo() {
        System.out.println("Nama Brand: " + getNamaBrand() +
                "\nKategori: " + getKategori() +
                "\nTahun Didirikan: " + getTahunDidirikan() +
                "\nNegara Asal: " + getNegaraAsal() +
                "\nHarga Resell: " + getHargaResell() +
                "\nKolaborasi: " + getKolaborasi());
    }

    public void displayType() {
        System.out.println("Hypebeast Brand");
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
            System.out.print("Masukkan jenis barang: ");
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
    
        // Brand brandYangAkanDiubah = brands.get(index);
    
        // System.out.print("Masukkan nama brand baru: ");
        // String namaBrandBaru = scanner.next();
        // System.out.print("Masukkan kategori baru (luxury/hypebeast): ");
        // String kategoriBaru = scanner.next();
        // System.out.print("Masukkan tahun didirikan baru: ");
        // int tahunDidirikanBaru = scanner.nextInt();
        // System.out.print("Masukkan negara asal baru: ");
        // String negaraAsalBaru = scanner.next();
    
        // brandYangAkanDiubah.setNamaBrand(namaBrandBaru);
        // brandYangAkanDiubah.setKategori(kategoriBaru);
        // brandYangAkanDiubah.setTahunDidirikan(tahunDidirikanBaru);
        // brandYangAkanDiubah.setNegaraAsal(negaraAsalBaru);
    
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