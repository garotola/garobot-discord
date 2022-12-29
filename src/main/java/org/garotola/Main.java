package org.garotola;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.garotola.listeners.CommandManager;
import org.garotola.listeners.EventManager;

import java.io.*;
import java.nio.file.Files;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader lerArq = new BufferedReader(new FileReader(Main.class.getResource("/config.txt").getFile()));
        String token = lerArq.readLine();
        lerArq.close();

        JDABuilder builder = JDABuilder.createDefault(token).enableIntents(GatewayIntent.MESSAGE_CONTENT);

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setActivity(Activity.playing("with your mom"));
        //builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        builder.addEventListeners(new CommandManager(), new EventManager());


        builder.build();
    }
}