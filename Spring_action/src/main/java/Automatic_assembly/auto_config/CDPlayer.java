package Automatic_assembly.auto_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer{
    private CompactDisc cd;

    @Autowired(required = false)
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }
    public void play(){
        cd.play();
    }
}
