package classi.obj;




import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Movimento implements Serializable {

    private LocalDate data;
    private String causale;
    private float importo;

    public Movimento() {
        this.data = LocalDate.now();
        this.causale = "";
        this.importo = 1;
    }
    
    public Movimento(float importo){
    
    this.data=LocalDate.now();
    this.causale="sconosciuto";
    }
    
    public Movimento(float importo,LocalDate data){
    this.importo=importo;
    this.data=data;
    this.causale="sconosciuto";
    }
    
    public Movimento(float importo,LocalDate data,String causale){
    this.importo=importo;
    this.data=data;
    this.causale=causale;
    }
    
    public Movimento(float importo ,String causale){
    this.importo=importo;
    this.data=LocalDate.now();
    this.causale=causale;
    }
    
    public Movimento (String [] vettore){
    this.importo=Float.parseFloat(vettore[0]);
    
    String [] vettore1= vettore[1].split("\\.");
    LocalDate data1=LocalDate.of(Integer.parseInt(vettore1[2]), Integer.parseInt(vettore1[1]), Integer.parseInt(vettore1[0]));
    this.data=data1;
    
    this.causale=vettore[2];
    }
    
    
    public float getImporto(){return this.importo;}
    public LocalDate getData(){return this.data;}
    public String getCausale(){return this.causale;}
    public String getDataFormatted(){return this.data.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));}
    public Movimento getCopy(){return new Movimento(this.importo,this.data,this.causale);}
    
    public void setImporto(float importo){this.importo=importo;}
    public void setData(LocalDate data){this.data=data;}
    public void setCausale(String causale){this.causale=causale;}
    
    
    public String toString(){
    return "importo:"+this.importo+"\tdata:"+getDataFormatted()+"\tcausale:"+this.causale;
    }
    
    

}
