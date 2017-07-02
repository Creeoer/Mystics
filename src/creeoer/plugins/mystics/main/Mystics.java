package creeoer.plugins.mystics.main;

import creeoer.plugins.mystics.main.listeners.Test;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by black on 7/1/2017.
 */
public class Mystics extends JavaPlugin{


@Override
    public void onEnable(){
    getCommand("test").setExecutor(new Test());
}



}
