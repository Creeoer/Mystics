package creeoer.plugins.mystics.main.user;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.*;

/**
 * Created by Frank on 7/2/2017.
 */
public class WizardBoard {

    Scoreboard board;
    Objective currentSpell;

    public WizardBoard(Wizard wizard){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        board = manager.getNewScoreboard();
Bukkit.broadcastMessage("ran");
        /*
        Type

        Mana

        Current Selected Spell
         */
        Objective mana = board.registerNewObjective("mana", "dummy");
        mana.setDisplaySlot(DisplaySlot.SIDEBAR);
        mana.setDisplayName("Mana");
        mana.getScore("Mana:").setScore(wizard.getMana());

    }

    public Scoreboard getBoard(){
        return board;
    }


    public void setCurrentSpell(String spellName){
        currentSpell.setDisplayName("Current Spell: " + spellName);
    }
}
