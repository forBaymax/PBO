package POSTTEST3;

import java.util.ArrayList;

class LuxuryBrand extends Brand {
    private double hargaTertinggi;
    private String merkBrand;

    public LuxuryBrand(String namaBrand, String kategori, int tahunDidirikan, String negaraAsal, double hargaTertinggi, String merkBarang) {
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
    
    public String getmerkBrand(){
        return merkBrand;
    }
    
    public void setmerkBrand(){
        this.merkBrand = merkBrand;
    }
}




class HypebeastBrand extends Brand {
    private ArrayList<String> collab;
    private double hargaResell;

    public HypebeastBrand(String namaBrand, String kategori, int tahunDidirikan, String negaraAsal, String kolaborasi, double hargaResell) {
        super(namaBrand, kategori, tahunDidirikan, negaraAsal);
        this.collab = collab;
        this.hargaResell = hargaResell;
    }

    public ArrayList<String> getcollab() {
        return collab;
    }

    public void setcollab(ArrayList<String> collab) {
        this.collab = collab;
    }

    public double gethargaResell() {
        return hargaResell;
    }

    public void sethargaResell(double hargaResell) {
        this.hargaResell = hargaResell;
    }
}