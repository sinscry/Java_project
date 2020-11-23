package Automatic_assembly.xml_config;


import Automatic_assembly.java_config.CompactDisc;
import Automatic_assembly.java_config.MediaPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../../../resources/xml_config.Automatic_assembly/Beans.xml")
public class CDPlayerTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeBull(){
        assertNotNull(cd);
    }
    @Test
    public void play(){
        player.play();
//        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",
//                    systemOutRule.getLog());
    }
}
