/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import sun.audio.*;
import java.io.*;
import javax.sound.sampled.*;


public class Breakout extends JFrame {

    public Breakout() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        setTitle("My First Game Brick Breaker");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                Breakout game = new Breakout();
                game.setVisible(true); 
            }
        });
        File clap=new File("Sound.wav");
        playsound(clap);
    }
    /*public static abstract class AL implements ActionListener
    {
        public final void actionPerformed(ActionEvent e)
       {
            music();
        }
    }
 
 
    public static void music ()
 
    {
       AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;
 
    try
    {
    BGM = new AudioStream (new FileInputStream ("D:\\Sound.WAV"));
    MD = BGM.getData();
    loop = new ContinuousAudioDataStream(MD);
     }
 
     catch (IOException error){
        System.out.println("File not found");
     }
 
 
     MGP.start(loop);
    }*/
    public static void playsound(File Sound){
        try{
            Clip clip=AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            
            Thread.sleep(10);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(Exception e){
            
        }
    }
    
 
}
