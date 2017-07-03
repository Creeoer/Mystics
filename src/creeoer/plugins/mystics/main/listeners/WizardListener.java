package creeoer.plugins.mystics.main.listeners;

import creeoer.plugins.mystics.main.Mystics;
import creeoer.plugins.mystics.main.crystal.MagicType;
import creeoer.plugins.mystics.main.manager.WizardManager;
import creeoer.plugins.mystics.main.user.Wand;
import creeoer.plugins.mystics.main.user.Wizard;
import creeoer.plugins.mystics.main.user.WizardBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Frank on 7/2/2017.
 */
public class WizardListener implements Listener {



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        String id = e.getPlayer().getUniqueId().toString();
        if(!new File(Mystics.getInstance().getDataFolder() + File.separator  + "playerData" + File.separator + id + ".yml").exists()){

            File wizardFile = new File(Mystics.getInstance().getDataFolder() + File.separator  + "playerData" + File.separator + id + ".yml");
            try {
                wizardFile.createNewFile();
            } catch (IOException e1) {
                Bukkit.getLogger().severe("Couldn't create new wizard file!" + wizardFile);
                return;
            }
            YamlConfiguration data = YamlConfiguration.loadConfiguration(wizardFile);
            String[] spells = {"Cleanse", "FireBoulder", "Glide", "SuddenDeath", "Trap"} ;
            data.set("type", "dark");
            data.set("mana", 200);
            data.set("learnedSpells", spells);
            try {
                data.save(wizardFile);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            Wand wand = new Wand(MagicType.DARK);
            e.getPlayer().getInventory().setItem(0, wand.getWandItem());
            e.getPlayer().sendMessage(ChatColor.AQUA + "Welcome new wizard!");


            ItemStack spellBook = new ItemStack(Material.BOOK_AND_QUILL, 1);
            ItemMeta meta = spellBook.getItemMeta();
            meta.setDisplayName("Spell Book");
            spellBook.setItemMeta(meta);
            e.getPlayer().getInventory().setItem(1, spellBook);
            WizardManager.getInstance().add(new Wizard(UUID.fromString(id)));
        }

        if(!WizardManager.getInstance().contains(e.getPlayer().getName()))
        WizardManager.getInstance().add(new Wizard(e.getPlayer().getUniqueId()));



        e.getPlayer().sendMessage(ChatColor.AQUA + "Welcome back wizard!");
        WizardBoard board = new WizardBoard(WizardManager.getInstance().getWizard(e.getPlayer().getName()));
        e.getPlayer().setScoreboard(board.getBoard());

    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        if(WizardManager.getInstance().contains(e.getPlayer().getName())){
            WizardManager.getInstance().remove(e.getPlayer().getName());
        }
    }


}
