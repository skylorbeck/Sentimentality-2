package website.skylorbeck.sentimentality2;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "sentimentality2")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    boolean showItems = true;

    public boolean repairCost = true;

    public boolean pingIndicator = true;

    public boolean infinityFix = true;

    public boolean itemEntity = true;

    public boolean beehiveTips = true;

    @ConfigEntry.Gui.CollapsibleObject()
    clockStuff clockStuff = new clockStuff();

    @ConfigEntry.Gui.CollapsibleObject()
    sleepStuff sleepStuff = new sleepStuff();

    @ConfigEntry.Gui.CollapsibleObject()
    toggles toggles = new toggles();
    static class toggles {
        @ConfigEntry.Gui.Tooltip
        @ConfigEntry.Gui.RequiresRestart
        boolean chunker = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean slimer = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean daylighter = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean fleather = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean charcoal = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean coalChunks = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean sticks = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean featherBlock = true;

        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.Gui.Excluded
        boolean gliders = false;

        @ConfigEntry.Gui.RequiresRestart
        boolean furnaces = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean blasts = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean smokers = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean woolArmor = true;

        @ConfigEntry.Gui.RequiresRestart
        boolean allTools = true;
        @ConfigEntry.Gui.CollapsibleObject()
        toolToggles toolToggles = new toolToggles();
        @ConfigEntry.Gui.RequiresRestart
        boolean allCompressedBlocks = true;
        @ConfigEntry.Gui.CollapsibleObject()
        compressedBlocks compressedBlocks = new compressedBlocks();
    }



    static class sleepStuff {
        boolean showSleepCount = true;
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(max = 100, min = 1)
        @ConfigEntry.Gui.Tooltip
        int sleepPercent = 50;
    }

    static class clockStuff {
        @ConfigEntry.BoundedDiscrete(max = 3)
        @ConfigEntry.Gui.Tooltip(count = 4)
        int clockCorner = 1;
        boolean clockMilitary = false;
        boolean clockAmPm = true;
    }

    static class toolToggles{
        @ConfigEntry.Gui.RequiresRestart
        boolean graniteTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean dioriteTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean andesiteTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean quartzTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean netherrackTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean netherbrickTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean redNetherbrickTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean sandstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean redSandstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean lapisTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean emeraldTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean flintTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean redstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean blackstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean basaltTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean endstoneTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean warpedTools = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean crimsonTools = true;
    }

    static class compressedBlocks{
        @ConfigEntry.Gui.RequiresRestart
        boolean cobble = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean dirt = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean diorite = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean andesite = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean granite = true;
        @ConfigEntry.Gui.RequiresRestart
        boolean netherrack = true;
    }
}