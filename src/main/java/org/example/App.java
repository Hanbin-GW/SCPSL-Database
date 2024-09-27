package org.example;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.example.Commands.HelloCommand;
import org.example.Commands.PingCommand;

public class App extends ListenerAdapter {
    public static void main(String[] args) throws Exception{
        String token = Token.DiscordBotToken; // 복사한 토큰을 여기에 입력하세요
        JDABuilder jdaBuilder = JDABuilder.createDefault(token)
                .addEventListeners(new App())
                .addEventListeners(new HelloCommand())
                .addEventListeners(new PingCommand())
                .setActivity(Activity.playing("Hello World!"));
        jdaBuilder.build().updateCommands()
                .addCommands(
                        Commands.slash("ping", "Returns Pong!"),
                        Commands.slash("hello", "Greets the user")
                ).queue();


    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // 봇 메시지는 무시합니다
        if (event.getMessage().getContentRaw().equals("안녕하세요")) {
            event.getChannel().sendMessage(event.getAuthor()+" 님 만나서 반가워요!").queue();
        }
    }
}
