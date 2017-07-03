package creeoer.plugins.mystics.main.manager;

import creeoer.plugins.mystics.main.Mystics;
import creeoer.plugins.mystics.main.user.Wizard;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Frank on 7/2/2017.
 */
public class WizardManager {

    private static HashMap<String, Wizard> wizards = new HashMap<>();
    private static final WizardManager instance = new WizardManager();
    //Initializes all wizards on startup

    public static WizardManager getInstance() {
        return instance;
    }


    public void add(Wizard wiz) {
        wizards.put(wiz.getName(), wiz);
    }

    public Wizard getWizard(String pName) {
        return wizards.get(pName);
    }

    public boolean contains(String pName){
        if(wizards.containsKey(pName))
            return true;

        return false;
    }

    public void remove(String pName) {
        wizards.remove(pName);
    }

    //Wizard lookup

    public void init() {
        File dir = new File(Mystics.getInstance().getDataFolder() + File.separator + "playerData");

        for (File user : dir.listFiles()) {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(user);
            Wizard wiz = new Wizard(UUID.fromString(user.getName().replace(".yml", "")));
            Player p = Bukkit.getPlayer(UUID.fromString(user.getName().replace(".yml", "")));
            wizards.put(p.getName(), wiz);

        }
    }
}
