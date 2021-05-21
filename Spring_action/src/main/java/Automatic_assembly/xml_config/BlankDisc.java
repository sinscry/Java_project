package Automatic_assembly.xml_config;

import Automatic_assembly.java_config.CompactDisc;

import java.util.List;
import java.util.SplittableRandom;

public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;


    public BlankDisc(String title, String artist, List<String> tracks){
        this.title=title;
        this.artist=artist;
        this.tracks=tracks;//磁道，CD通常10磁道，每磁道一首歌
    }
    public void play(){
        System.out.println("Playing "+ title + " by " + artist);
        for (String track:tracks){
            System.out.println("-Track: "+track);
        }
    }
}
