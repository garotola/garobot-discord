package org.garotola.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.garotola.commands.Command;
import org.garotola.commands.Help;
import org.garotola.commands.Ping;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.HashMap;
import java.util.Map;

public class CommandManager extends ListenerAdapter {
    static Map<String, Command> commandDataList = new HashMap();

    @Override
    public void onReady(ReadyEvent event) {
        // Lista de Comandos
        commandDataList.put("ping", new Ping());
        commandDataList.put("help", new Help());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String input = event.getMessage().getContentDisplay().toLowerCase();

        if(!event.getAuthor().getName().equals("Garobot") && input.contains("garobot")) {
            String[] values = input.split("!");
            String command = values[1];
            try {
                commandDataList.get(command).onReady(event);
            } catch (NullPointerException err) {
                event.getChannel().sendMessage("Garobot não tem esse comando").queue();
            }
        }
    }

    public static Map<String, Command> getCommandDataList() {
        return commandDataList;
    }
}
