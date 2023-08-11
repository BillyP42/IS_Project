public class Drago extends Personaggio{
    private static Drago uniqueInstance=null;
    private Drago(){
        this.x=260;
        this.y=100;
        this.HP=15;
        this.azioni=1;
        this.MAX_azioni=1;


    }
    public static Drago getinstance(){
        if (uniqueInstance == null) {
            uniqueInstance = new Drago();
        }
        return uniqueInstance;
    }

}
