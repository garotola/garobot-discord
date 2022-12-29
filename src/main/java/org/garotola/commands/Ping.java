package org.garotola.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.garotola.messages.EmbedMessage;

public class Ping extends Command {

    public Ping() {
        super("Retorna o tempo de resposta do Bot");
    }

    @Override
    public void onReady(MessageReceivedEvent event) {
        MessageEmbed embed = EmbedMessage.createEmbedMessage(
                "\uD83C\uDFD3 | Ping Pong",
                "\uD83D\uDCC8 | "+ event.getJDA().getGatewayPing() + " ms",
                event.getAuthor().getName()
        );
        event.getChannel().sendMessageEmbeds(embed).queue();
    }

}
//✏