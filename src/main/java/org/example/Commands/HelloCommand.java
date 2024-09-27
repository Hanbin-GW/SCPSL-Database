package org.example.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloCommand extends ListenerAdapter{
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        // 슬래시 명령어가 "hello"인 경우에만 처리
        if (event.getName().equals("hello")) {
            event.reply("안녕하세요!").queue();  // "안녕하세요!"라는 메시지를 응답
        }
    }
}
