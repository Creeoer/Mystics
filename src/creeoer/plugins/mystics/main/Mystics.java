package creeoer.plugins.mystics.main;

import creeoer.plugins.mystics.main.listeners.SpellBook_Listener;
import creeoer.plugins.mystics.main.listeners.Spell_Listener;
import creeoer.plugins.mystics.main.listeners.WizardListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * Created by black on 7/1/2017.
 */
public class Mystics extends JavaPlugin{
    private static Mystics instance;

@Override
    public void onEnable(){
    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new Spell_Listener(), this);
    pm.registerEvents(new WizardListener(), this);
    pm.registerEvents(new SpellBook_Listener(), this);
    instance = this;

    if(!getDataFolder().exists()){

        try {
            getDataFolder().mkdir();
            new File(getDataFolder() + File.separator + "playerData").mkdir();
        } catch (Exception e) {
            getLogger().severe("Couldn't generate data folder!");
        }
    }
}

public static Mystics getInstance(){
        return instance;
}



}
