package pl.wipb.ztp.ps3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


class Game extends JPanel {
    private final int TILESIZE = 32;
    private final List<Segment> plansza;
    private final Sprite sprite;

    private void stworzPlansze(String plik, Builder builder) {
        
        
        BufferedReader br = null;
        try {
            InputStream pFile = getClass().getResourceAsStream(plik);
            br = new BufferedReader(new InputStreamReader(pFile));
            //List<Segment> plansza = new ArrayList<>();
            String linia;
           // int x;
           // int y = 4;
            int liczba;
            int znaki;
            char znak;
            char cyfra1;
            char cyfra2;
            while ((linia = br.readLine()) != null) {
               // x = 4;
                znaki = 0;
                while ((linia.length() - znaki) >= 3) {
                    znak = linia.charAt(znaki++);
                    cyfra1 = linia.charAt(znaki++);
                    cyfra2 = linia.charAt(znaki++);
                    liczba = (cyfra1 - '0') * 10 + (cyfra2 - '0');

                    builder.createSegment(znak, liczba);
                }
                builder.NextRow();
            }
            br.close();
           // return plansza;
        } catch (IOException e) {
            System.out.println("Blad wczytania planszy");
            e.printStackTrace();
           // return null;
        }
    }

    public Game(String plik) {
        setPreferredSize(new Dimension(424, 268));
        setFocusable(true);

        //Builder builder1 = new Builder1();
        Builder builder2 = new Builder2();
        stworzPlansze(plik, builder2);
        plansza = builder2.GetBoard();

        sprite = new Sprite(plansza, "mario.png");
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev) {
                switch (ev.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        sprite.stop();
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent ev) {
                switch (ev.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        sprite.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        sprite.right();
                        break;
                    case KeyEvent.VK_SPACE:
                    case KeyEvent.VK_UP:
                        sprite.jump();
                        break;
                }
            }
        });
        
        new Thread(new SpriteController(sprite, plansza, this)).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Segment s : plansza) {
            s.draw(g);
        }
        sprite.draw(g);
    }
    
}
