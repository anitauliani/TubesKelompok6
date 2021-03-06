/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author ASUS
 */
public class Dosen extends Orang {
    
    private long nip;
    private Kelas[] kelas; //default maxKelas = 5
    private int maxKelas;
    private int jumlahKelas = 0;

    @Override
    public String toStringJenis() {
        return "Dosen";
    }

    public Dosen() {
        super.setNama("Default");
        kelas = new Kelas[5];
        maxKelas = 5;
    }

    public Dosen(long nip) {
        this.nip = nip;
        kelas = new Kelas[5];
        maxKelas = 5;
    }
    
    public Dosen(String nama, long nip, int maxKelas){
        this.nip = nip;
        super.setNama(nama);
        kelas = new Kelas[maxKelas];
    }

    public long getNip() {
        return nip;
    }    
    public void setNip(long nip) {
        this.nip = nip;
    }
    public int getMaxKelas() {
        return maxKelas;
    }
    public void setMaxKelas(int maxKelas) {
        this.maxKelas = maxKelas;
    }
    public void createKelas(String nama){
        if(jumlahKelas<maxKelas){
            kelas[jumlahKelas++] = new Kelas(nama);
            
        } 
    }
    public void createKelas(String nama,String kodeMK ,int jumlahMhs){
        if(jumlahKelas<maxKelas){
            kelas[jumlahKelas++] = new Kelas(nama);
            kelas[jumlahKelas-1].setMataKuliah(new MataKuliah(kodeMK));
            kelas[jumlahKelas-1].setMaxMhs(jumlahMhs);
            
            
        } 
    }
    public void deleteKelas(int n){
        if(jumlahKelas>0){
            if(n==jumlahKelas-1){
                kelas[n] = null;
                jumlahKelas--;
            }
            else if(jumlahKelas==1){
                kelas[n]=null;
             }
            else{
                kelas[n]= null;
                for(int i=n;i<jumlahKelas-1;i++){
                    kelas[i] = kelas[i+1];
                }
            }
        }
       
    }
    public Kelas getKelas(int n){
        return kelas[n];
    }
    
    
    public int idxKelas(String name){
        int idx=-1;
        for(int i=0;i<jumlahKelas;i++){
            if(name.equals(kelas[i].getNama())){
                idx = i;
            }
        }
        return idx;
    }
    
    public int getJumlahKelas(){
        return this.jumlahKelas;
    }

    public void AssignTugas(Kelas k, Tugas t){
        t.setStatusAssign(true);
        for (int i = 0; i < k.getJumlahMhs(); i++) {
            
            k.getMahasiswa(i).createmyTugas(t); 
            k.getMahasiswa(i).addTugas(t);
        }
    
    }

}
