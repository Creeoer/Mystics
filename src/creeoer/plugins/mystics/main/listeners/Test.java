package creeoer.plugins.mystics.main.listeners;

import creeoer.plugins.mystics.main.generator.CrystalGenerator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by black on 7/1/2017.
 */
public class Test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (command.getLabel().equalsIgnoreCase("test")) {

            CrystalGenerator generator = new CrystalGenerator();
            Player p = (Player) sender;
            generator.generate(((Player) sender).getLocation().getChunk());

        }

        return false;
    }
}
