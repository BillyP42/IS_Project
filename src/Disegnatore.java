import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Disegnatore extends Canvas {
    public void disegna(BufferedImage sfondo){

        BufferStrategy buffer=this.getBufferStrategy();
        if(buffer==null){
            createBufferStrategy(2);
            return;
        }
        Graphics g= buffer.getDrawGraphics();
        g.drawImage(sfondo,0,0,720,900,null);
        
        g.dispose();
        buffer.show();

        //System.out.println(g);

    }
    public void disegna_griglia(){

        BufferStrategy buffer=this.getBufferStrategy();
        if(buffer==null){
            createBufferStrategy(2);
            return;
        }
        Graphics g= buffer.getDrawGraphics();



        g.drawLine(60,100,560,100);
        g.drawLine(60,600,560,600);
        g.drawLine(60,100,60,600);
        g.drawLine(560,100,560,600);

        for(int i=2;i<=5;i++){
            g.drawLine(60,100*i,560,100*i);
            g.drawLine(60+100*(i-1),100,60+100*(i-1),600);
        }

        g.dispose();
        buffer.show();
    }
    public void disegna_token(BufferedImage token,int x,int y){
        BufferStrategy buffer=this.getBufferStrategy();
        if(buffer==null){
            createBufferStrategy(2);
            return;
        }
        Graphics g= buffer.getDrawGraphics();

        g.drawImage(token,x,y,100,100,null);

        g.dispose();
        buffer.show();
    }
    public void pulizia() {
        BufferStrategy buffer=this.getBufferStrategy();
        if(buffer==null){
            createBufferStrategy(2);
            return;
        }
        Graphics g= buffer.getDrawGraphics();
        g.clearRect(0,0,720,900);
    }
    public void Scrivi_turno(String stato){
        BufferStrategy buffer=this.getBufferStrategy();
        if(buffer==null){
            createBufferStrategy(2);
            return;
        }
        Graphics g= buffer.getDrawGraphics();
        g.drawString("Turno di "+ stato,300,700);

        g.dispose();
        buffer.show();
    }

}
