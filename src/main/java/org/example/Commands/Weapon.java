package org.example.Commands;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;


public class Weapon extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        if (event.getMessage().getContentRaw().startsWith("/Weapon")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Working in progress...");             // 임베드 제목
            embed.setDescription("현재 커맨드가 재작중에 있습니다..."); // 설명 텍스트
            embed.setColor(Color.red);                      // 임베드 색상
            //embed.addField("필드 1", "이것은 필드 1의 내용입니다.", false); // 필드 추가
            //embed.addField("필드 2", "이것은 필드 2의 내용입니다.", false);
            embed.setFooter("Made by Ghost World", "https://static.wikia.nocookie.net/callofduty/images/7/71/Ghosts_insignia_CoDG.png/revision/latest?cb=20191109155834");
            event.getChannel().sendMessageEmbeds(embed.build()).queue();
        }
    }
}
