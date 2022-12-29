package org.garotola.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.garotola.listeners.CommandManager;
import org.garotola.messages.EmbedMessage;

import java.util.Map;

public class Help extends Command{
    public Help() {
        super("Informa as informações dos comandos");
    }

    @Override
    public void onReady(MessageReceivedEvent event) {
        Map<String, Command> commands = CommandManager.getCommandDataList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("** Uso dos caomandos : gb!command **\n");
        commands.forEach(((s, command) -> {
            stringBuilder.append(s).append(" : ").append(command.getDescription()).append("\n");
        }));
        MessageEmbed embed = EmbedMessage.createEmbedMessage(
                "❓ | Ajuda nos comandos",
                stringBuilder.toString(),
                event.getAuthor().getName()
        );

        event.getChannel().sendMessageEmbeds(embed).queue();

    }
}
