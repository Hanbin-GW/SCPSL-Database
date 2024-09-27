package org.example.Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
    private static final String COMMAND_PREFIX = "!";

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()){
            return;
        }
        String message = event.getMessage().getContentRaw();

        if(message.startsWith(COMMAND_PREFIX + "ping")){
            event.getChannel().sendMessage("Pong!").queue();
        }
    }
}
