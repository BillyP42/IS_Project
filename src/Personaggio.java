public abstract class Personaggio {
    int HP;
    int azioni;
    int MAX_azioni;
    int x;
    int y;
    public void movimento_ascissa(int x){
        int result=this.x;
        for(int i=0;i<5;i++){
            if((x>=60+100*i)&&(x<60+100*(i+1))){
                result=60+100*i;
            }
        }
        this.x=result;
    }
    public void movimento_ordinata(int y){
        int result=this.y;
        for(int i=0;i<5;i++){
            if((y>=100+100*i)&&(y<100+100*(i+1))){
                result=100+100*i;
            }
        }
        this.y=result;
    }
    public void attacco(String attaccante){

    }
    public void speciale(){}
    public void set_X(int ascissa){
        this.x=ascissa;
    }
    public void set_Y(int ordinata){
        this.y=ordinata;
    }
    public int get_X(){
        return this.x;
    }
    public int get_Y(){
        return this.y;
    }
    public void reset_azioni(){this.azioni=this.MAX_azioni;}
    public int get_azioni(){return this.azioni;}

    public void decrementa_azioni(){this.azioni--;}
}
