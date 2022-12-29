package org.garotola.events;

import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.garotola.messages.EmbedMessage;

public class MemberJoin extends ListenerAdapter {

    private String idChannel = "937785680845733948";
    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        MessageEmbed embed = EmbedMessage.createEmbedMessage(
                "\uD83D\uDD19 **Relatório de Saída**",
                event.getMember().getNickname() + " acabou de sair desse servidor",
                "Garobot"
        );

        event.getGuild().getTextChannelById(idChannel).sendMessageEmbeds(embed);
    }

}
