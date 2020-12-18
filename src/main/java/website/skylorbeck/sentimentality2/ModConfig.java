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

    boolean showSleepCount = true;
    @ConfigEntry.Gui.Tooltip
    boolean showItems = true;
}