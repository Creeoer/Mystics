package creeoer.plugins.mystics.main.generator;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

/**
 * Created by Frank on 7/2/2017.
 */
public class Generator implements Listener {

    private CrystalGenerator generator;

    public Generator(){
        generator = new CrystalGenerator();
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event){
        if(event.isNewChunk()) {
            generator.generate(event.getChunk());
        }
    }
}
