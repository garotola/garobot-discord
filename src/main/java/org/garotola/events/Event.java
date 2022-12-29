package org.garotola.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Event {
    public abstract void onReady(MessageReceivedEvent event);
}
