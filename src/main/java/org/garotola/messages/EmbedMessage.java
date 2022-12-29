package org.garotola.messages;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.Event;

import java.time.LocalDateTime;

public class EmbedMessage {

    static EmbedBuilder embed = new EmbedBuilder();

    public static MessageEmbed createEmbedMessage(String title, String description, String author) {
        embed.setTitle(title);
        embed.setDescription(description);
        embed.setFooter("Requerido por " + author);
        embed.setTimestamp(LocalDateTime.now());
        return embed.build();
    }


}
