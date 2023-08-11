import java.util.ArrayList;

public class Gioco {
    private Schermata schermo;
    private Cavaliere Cav1;
    private Cavaliere Cav2;
    private Boolean combattimento=false;
    private Boolean movimento=false;
    private Boolean speciale=false;
    private Drago drago;
    private String Stato="cav1";
    public Gioco(){
        drago= drago.getinstance();
        Cav1=new Cavaliere();
        Cav2=new Cavaliere();
        Cav1.set_X(160);Cav1.set_Y(500);
        Cav2.set_X(360);Cav2.set_Y(500);
        schermo=new Schermata(this);

    }
    public void richiesta_movimento(String pedina,int x,int y){

        switch(pedina){
            case "drago": drago.movimento_ascissa(x);
                          drago.movimento_ordinata(y);
                          //System.out.println("xf:" + drago.get_X() + "yf:" + drago.get_Y());
                          break;
            case "cav1": Cav1.movimento_ascissa(x);
                         Cav1.movimento_ordinata(y);
                //System.out.println("xf:" + drago.get_X() + "yf:" + drago.get_Y());
                break;
            case "cav2": Cav2.movimento_ascissa(x);
                         Cav2.movimento_ordinata(y);
                //System.out.println("xf:" + drago.get_X() + "yf:" + drago.get_Y());
                break;
        }
    }
    public int richiesta_coordinata_x(String soggetto){
        int result =0;
        switch(soggetto){
            case "drago": result= drago.get_X();
                break;
            case "cav1": result= Cav1.get_X();
                break;
            case "cav2": result= Cav2.get_X();
                break;
        }
        return result;
    }
    public int richiesta_coordinata_y(String soggetto){
        int result =0;
        switch(soggetto){
            case "drago": result= drago.get_Y();
                break;
            case "cav1": result= Cav1.get_Y();
                break;
            case "cav2": result= Cav2.get_Y();
                break;
        }
        return result;
    }
    public String get_stato(){
        return this.Stato;

    }
    public void set_stato(String stato){
        this.Stato=stato;
        System.out.println(this.Stato);
    }
    public void turnazione(){

        switch(this.Stato){
            case "drago":
                if(drago.get_azioni()==0){
                    this.Stato= "cav1";
                    drago.reset_azioni();
                } else {
                    this.Stato="drago";
                    drago.decrementa_azioni();
                }
                break;
            case "cav1":
                this.Stato= "cav2";
                break;
            case "cav2":
                this.Stato= "drago";
                break;
        }


    }
    public Boolean permesso_movimento(){
        return this.movimento;
    }
    public Boolean permesso_attacco(){
        return this.combattimento;
    }
    public Boolean permesso_speciale(){
        return this.speciale;
    }
    public void set_movimento(Boolean situazione){
        this.movimento=situazione;
    }
    public void set_attacco(Boolean situazione){
        this.combattimento=situazione;
    }
    public void set_speciale(Boolean situazione){
        this.speciale=situazione;
    }
}
