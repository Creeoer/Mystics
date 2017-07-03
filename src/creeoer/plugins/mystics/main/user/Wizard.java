package creeoer.plugins.mystics.main.user;

import creeoer.plugins.mystics.main.Mystics;
import creeoer.plugins.mystics.main.Spells.Spell;
import creeoer.plugins.mystics.main.Spells.SpellFactory;
import creeoer.plugins.mystics.main.crystal.MagicType;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Frank on 7/2/2017.
 */
public class Wizard {

    /*
    type
    spells
    mana

     */

    Player player;
    File wizardFile;
    YamlConfiguration data;
    MagicType type;
    int mana;
    Set<Spell> learnedSpells;
    Spell currentSpell;


    public Wizard(UUID uuid){
        wizardFile = new File(Mystics.getInstance().getDataFolder() + File.separator + "playerData" + File.separator + uuid.toString() + ".yml");
        data = YamlConfiguration.loadConfiguration(wizardFile);
        learnedSpells = new HashSet<>();


        mana = data.getInt("mana");
        type = MagicType.parseType(data.getString("type"));
        for(String spellName: data.getStringList("learnedSpells")){
            Bukkit.broadcastMessage(spellName);
            learnedSpells.add(SpellFactory.getSpell(spellName));
        }

        UUID id = UUID.fromString(wizardFile.getName().replace(".yml", ""));
        player = Bukkit.getPlayer(id);

    }

    public MagicType getMagicType(){

        return type;
    }


    public Spell getCurrentSpell(){
return currentSpell;
    }

    public void setCurrentSpell(Spell spell){
        currentSpell = spell;
    }


    public Player getPlayer(){
        return player;
    }

    public String getName(){
return player.getName();
    }

    public int getMana(){
        return mana;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    public Set<Spell> getKnownSpells(){
    return learnedSpells;
    }
}
