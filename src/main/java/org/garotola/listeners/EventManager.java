package org.garotola.listeners;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.garotola.commands.Help;
import org.garotola.commands.Ping;
import org.garotola.events.MemberJoin;

public class EventManager extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        event.getJDA().addEventListener(
                new MemberJoin()
        );
    }

}
