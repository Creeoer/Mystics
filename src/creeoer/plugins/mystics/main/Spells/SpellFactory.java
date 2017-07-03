package creeoer.plugins.mystics.main.Spells;

/**
 * Created by Frank on 7/3/2017.
 */
public class SpellFactory {

    public static Spell getSpell(String spellName){
        switch(spellName) {
            case "Glide":
                return new Glide();
            case "Cleanse":
                return new Cleanse();
            case "FireBoulder": return new FireBoulder();
            case "Trap": return new Trap();
            case "SuddenDeath": return new SuddenDeath();

            default:
                return null;
        }
    }
}
