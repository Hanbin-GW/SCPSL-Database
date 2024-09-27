package org.example.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.Color;

public class EmbedCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        if (event.getMessage().getContentRaw().startsWith("embed")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("임베드 메시지 예제");             // 임베드 제목
            embed.setDescription("이것은 임베드 메시지의 설명입니다."); // 설명 텍스트
            embed.setColor(Color.LIGHT_GRAY);                      // 임베드 색상
            embed.addField("필드 1", "이것은 필드 1의 내용입니다.", false); // 필드 추가
            embed.addField("필드 2", "이것은 필드 2의 내용입니다.", false);
            embed.setFooter("임베드 메시지 푸터", null);
            event.getChannel().sendMessageEmbeds(embed.build()).queue();
        }
    }
}
