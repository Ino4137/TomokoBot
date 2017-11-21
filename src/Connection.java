import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Scanner;


public class Connection{
    static TextChannel playground;
    public static void main(String[] args){
        JDA discord = null;

        try {
            discord = new JDABuilder(AccountType.BOT).setToken(Constants.discordToken).buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }

        discord.addEventListener(new CommandHandler());
        BootOperations bo = new BootOperations();
        bo.scan();
/*
        Scanner sc = new Scanner(System.in);
//format: /embed TEXT}COLOR*CHANNEL

        if (sc.nextLine().startsWith("/embed")) {
            String command = sc.nextLine();
            String[] channel = command.split("*");
            String[] brokenDown = channel[0].split("}");

      //      List<TextChannel> getTextChannelsByName("Playground");

     //       channelz = JDA.getTextChannelsByName("Playground", true);

     //       channel[1].sendMessage("izo gett off me");
            try {

               Connection.getTextChannelsByName("Playground", true);
                .sendMessage(Embedener.DescriptionEmbed(brokenDown[0], null, brokenDown[1])).queue();
            } catch (Exception e) {
                playground.sendMessage(Embedener.DescriptionEmbed(command,null,"#796988")).queue();
            }
        }
    }
   /* @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        event.getChannel().sendMessage("Test");
        return;*/
    }
}

