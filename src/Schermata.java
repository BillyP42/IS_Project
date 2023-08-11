import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;

public class Schermata implements Runnable,MouseListener{

    private JFrame Schermo;
    private JPanel bottoni;
    private JButton Attacca;
    private JButton Muovi;
    private JButton Speciale;
    private JPanel schermo;
    private BufferedImage sfondo;
    private  BufferedImage token_drago;
    private  BufferedImage token_eroe_1;
    private  BufferedImage token_eroe_2;
    private Caricatore_Immagini caricatore;
    private Disegnatore disegnatore;
    private int stato=0;
    private Gioco pioco;



    public Schermata(Gioco gioco){
        pioco=gioco;
        Schermo=new JFrame("Drako");
        disegnatore=new Disegnatore();

        Attacca=new JButton("Attacca");
        Muovi=new JButton("Muovi");
        Speciale=new JButton("Speciale");

        bottoni=new JPanel();
        preparazione_immagini();


        disegnatore.addMouseListener(this);
        Schermo.add(disegnatore);
        Attacca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pioco.set_attacco(True);
            }
        });
        Muovi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //pioco.set_movimento(True);
            }
        });
        Speciale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //pioco.set_speciale(True);
            }
        });
        bottoni.add(Attacca);
        bottoni.add(Muovi);
        bottoni.add(Speciale);
        Schermo.add(bottoni, BorderLayout.SOUTH);
        Schermo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Schermo.setSize(720,900);
        Schermo.setResizable(false);
        Schermo.setVisible(true);
        Thread thread=new Thread(this);
        thread.start();


    }
    private void preparazione_immagini(){
        caricatore=new Caricatore_Immagini();
        sfondo=caricatore.carica_immagini("immagini/mappa.jpg");
        token_drago=caricatore.carica_immagini("immagini/token1.jpg");
        token_eroe_1=caricatore.carica_immagini("immagini/token2.jpg");
        token_eroe_2=caricatore.carica_immagini("immagini/token2.jpg");


    }

    @Override
    public void run() {
        while(true) {

            switch (stato){
                case 0:
                        disegnatore.disegna_griglia();
                        disegnatore.disegna_token(token_drago,pioco.richiesta_coordinata_x("drago"),pioco.richiesta_coordinata_y("drago"));
                        disegnatore.disegna_token(token_eroe_1,pioco.richiesta_coordinata_x("cav1"),pioco.richiesta_coordinata_y("cav1"));
                        disegnatore.disegna_token(token_eroe_2,pioco.richiesta_coordinata_x("cav2"),pioco.richiesta_coordinata_y("cav2"));
                        disegnatore.Scrivi_turno(pioco.get_stato());

                    break;

            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String tmp=pioco.get_stato();
        pioco.turnazione();
        pioco.richiesta_movimento(tmp, e.getX(), e.getY() );
        disegnatore.pulizia();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
