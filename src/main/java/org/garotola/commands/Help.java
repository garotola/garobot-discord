package org.garotola.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.garotola.listeners.CommandManager;
import java.util.Map;

public class Help extends Command{
    public Help() {
        super("Informa as informações dos comandos");
    }

    @Override
    public void onReady(MessageReceivedEvent event) {
        Map<String, Command> commands = CommandManager.getCommandDataList();
        StringBuilder stringBuilder = new StringBuilder();

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("❓ | Ajuda nos comandos");
        commands.forEach(((s, command) -> {
            stringBuilder.append(s).append(" : ").append(command.getDescription()).append("\n");
        }));
        embed.setDescription(stringBuilder.toString());
        embed.setFooter("Requerido por " + event.getAuthor().getName());
        event.getChannel().sendMessageEmbeds(embed.build()).queue();

    }
}
