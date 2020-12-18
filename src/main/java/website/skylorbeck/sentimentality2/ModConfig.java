package website.skylorbeck.sentimentality2;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "sentimentality2")
class ModConfig implements ConfigData {
    @ConfigEntry.BoundedDiscrete(max = 4)
    @ConfigEntry.Gui.Tooltip(count = 4)
    int clockCorner = 1;
}