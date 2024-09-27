package org.example;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
public class App extends ListenerAdapter {
    public static void main(String[] args) throws Exception{
        String token = Token.DiscordBotToken; // 복사한 토큰을 여기에 입력하세요
        JDABuilder.createDefault(token)
                .addEventListeners(new App())
                .setActivity(Activity.playing("Hello World!"))
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // 봇 메시지는 무시합니다
        if (event.getMessage().getContentRaw().equals("!ping")) {
            event.getChannel().sendMessage("Pong!").queue(); // !ping 명령어 처리
        }
    }
}
