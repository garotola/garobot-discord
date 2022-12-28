package org.garotola.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Command {
    private String description;

    public Command(String description){
        this.description = description;
    }

    public abstract void onReady(MessageReceivedEvent event);

    public String getDescription() {
        return description;
    }
}
