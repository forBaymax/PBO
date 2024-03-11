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

    public void setKategori(String kategori) {
        this.kategori = kategori;
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
        
        brands.add(new Brand(namaBrand, kategori, tahunDidirikan, negaraAsal));
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
            System.out.println("Belum ada data brand!");
            return;
        }
    
        System.out.println("Daftar Brand:");
        for (Brand brand : brands) {
            System.out.println("Nama Brand: " + brand.getNamaBrand());
            System.out.println("Kategori: " + brand.getKategori());
            System.out.println("Tahun Didirikan: " + brand.getTahunDidirikan());
            System.out.println("Negara Asal: " + brand.getNegaraAsal());
            System.out.println("--------------------------");
        }
    }
    

    private static void ubahBrand() {
        if (brands.isEmpty()) {
            System.out.println("Belum ada data brand!");
            return;
        }
        
        tampilkanBrand();
        System.out.print("Masukkan nomor indeks brand yang ingin diubah: ");
        System.out.print("(Indeks di mulai dari 0.) ");
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
        System.out.print("Masukkan indeks brand yang ingin dihapus: ");
        int index = scanner.nextInt();
        brands.remove(index);
        System.out.println("Brand berhasil dihapus!");
    }
}
