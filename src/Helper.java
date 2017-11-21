import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Helper {
    public void help(MessageReceivedEvent event)
    {
        event.getTextChannel().sendMessage(Embedener.wrapMessageInEmbed(Constants.helpText, "Available Commands")).queue();
    }

}
