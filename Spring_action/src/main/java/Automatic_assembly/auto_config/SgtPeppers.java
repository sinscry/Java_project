package Automatic_assembly.auto_config;

import org.springframework.stereotype.Component;

@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play(){
        System.out.println("Playing "+title+" by "+artist);
    }
}
