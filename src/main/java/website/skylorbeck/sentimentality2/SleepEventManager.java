package website.skylorbeck.sentimentality2;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;

import java.util.List;

public class SleepEventManager {
    public static int percent = 50;
    public static void onTick(MinecraftServer server) {
        server.getWorlds().forEach((world) -> {
            List<ServerPlayerEntity> players = world.getPlayers();
            int sleeping = 0;
            for (PlayerEntity p : players) {
                if (p.isSleeping() && p.isSleepingLongEnough())
                    sleeping++;
            }
            if (sleeping != players.size() && sleeping * 100 / players.size() >= percent) {
                sleep(world, players);
            }
        });
    }

    private static void sleep(ServerWorld world, List<ServerPlayerEntity> players) {
        if(world.getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE)){
            long l = world.getLevelProperties().getTimeOfDay() + 24000L;
            world.setTimeOfDay(l - l%24000);
        }
        if(world.getGameRules().getBoolean(GameRules.DO_WEATHER_CYCLE)){
            world.setWeather(0,0,false ,false);
        }

        players.forEach(p-> {
            if (p.isSleeping()) {
                p.wakeUp(false, true);
            }
        });
    }
}