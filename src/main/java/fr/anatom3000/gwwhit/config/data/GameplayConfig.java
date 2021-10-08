package fr.anatom3000.gwwhit.config.data;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.fabricmc.fabric.api.util.TriState;

@Config(name = "gameplay")
public class GameplayConfig implements ConfigData {
    GameplayConfig(){}

    @ConfigEntry.Gui.CollapsibleObject
    public Items items = new Items();
    @ConfigEntry.Gui.CollapsibleObject
    public Blocks blocks = new Blocks();
    public boolean stoneBlocksAreInfected = false;
    public boolean mobsMayExplode = false;
    @ConfigEntry.Gui.Tooltip
    public boolean killCulling = false;
    public boolean randomizedDrops = false;
    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean dreamLuck = false;
    public TriState fluidPhysics = TriState.DEFAULT;

    public static class Items {
        @ConfigEntry.Gui.RequiresRestart
        public boolean everythingIsEdible = false;
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        public boolean hiddenItemsTab = false;
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(min = 1, max = 64)
        public int maxStackSize = 64;
        @ConfigEntry.Gui.Tooltip
        public boolean noHardcodedItemCooldown = false;
    }

    public static class Blocks {
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(max = 1)
        public float defaultSlipperiness = 0.6F;
        public boolean everythingBurns = false;
        @ConfigEntry.Gui.RequiresRestart
        public boolean replaceEverything = false;
    }
}
