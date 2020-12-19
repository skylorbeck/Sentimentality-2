package website.skylorbeck.sentimentality2;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "sentimentality2")
class ModConfig implements ConfigData {



    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    clockStuff clockStuff = new clockStuff();

    static class clockStuff {
        @ConfigEntry.BoundedDiscrete(max = 3)
        @ConfigEntry.Gui.Tooltip(count = 4)
        int clockCorner = 1;
        boolean clockMilitary = false;
        boolean clockAmPm = true;
    }
    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    sleepStuff sleepStuff = new sleepStuff();

    static class sleepStuff {
        boolean showSleepCount = true;
        @ConfigEntry.BoundedDiscrete(max = 100,min = 1)
        @ConfigEntry.Gui.Tooltip
        int sleepPercent = 50;
    }
    @ConfigEntry.Gui.Tooltip
    boolean canUseChunker = true;


    @ConfigEntry.Gui.Tooltip
    boolean showItems = true;


}