import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.stack.overflow.works.model.Data;


public class CommandHandler extends ListenerAdapter{

    private void displayRecords(List<Data> recordList, MessageReceivedEvent event) {
        System.out.println("USER" + Constants.TAB_SPACE + "ELO" + Constants.TAB_SPACE + "ROLE 1"+ Constants.TAB_SPACE + "ROLE 2");
        for (Data data: recordList) {
            System.out.println(data.getUserID() + Constants.TAB_SPACE + data.getElo() + Constants.TAB_SPACE + data.getRole1() + Constants.TAB_SPACE + data.getRole2());
            event.getTextChannel().sendMessage("<@"+data.getUserID()+ ">" + Constants.TAB_SPACE + data.getElo() + Constants.TAB_SPACE + data.getRole1() + Constants.TAB_SPACE + data.getRole2()).queue();
        }
    }

    public void onMessageReceived(MessageReceivedEvent event) {

        String message = event.getMessage().getContent();
        String response = "";

        if (message.equals("/lovetest")) {

            String name = event.getAuthor().getName();
            long id = event.getAuthor().getIdLong();
            System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new java.util.Date()) + "] [CommandHandler] /lovetest | by: " + event.getAuthor().getName()+" ID: "+event.getAuthor().getId());
            if (id == 299540437276950528L) response = "Welperooni-san... I..I love you!";
            else {
                response = name + ", get away from me.";
            }

            event.getTextChannel().sendMessage(response).queue();
        }
        if (message.equals("/rr new")) {
            RRoller rr = new RRoller("neu", event);
            System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new java.util.Date()) + "] [CommandHandler] /rr new | by: " + event.getAuthor().getName()+" ID: "+event.getAuthor().getId());
            rr.roll(event);
        }
        if (message.equals("/rr")) {
            RRoller rr = new RRoller();
            System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new java.util.Date()) + "] [CommandHandler] /rr | by: " + event.getAuthor().getName()+" ID: "+event.getAuthor().getId());
            rr.roll(event);
        }

        if (message.equals("/help")) {
            Helper he = new Helper();
            he.help(event);
            System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new java.util.Date()) + "] [CommandHandler] /help | by: " + event.getAuthor().getName()+" ID: "+event.getAuthor().getId());
            displayRecords(Constants.recordList, event);
        }

  /*      if (message.equals("/d20")) {
            DnDRoller dnd = new DnDRoller(20);
            dnd.roll(event);
        }*/
        if (Pattern.matches("(/d\\d+)", event.getMessage().getContent())) {
            int x = 0;
            String rollo = event.getMessage().getContent();
            String rollo1 = rollo.substring(2);
            try {
                x = Integer.valueOf(rollo1);
                DnDRoller dnd = new DnDRoller(x);
                dnd.roll(event);
            } catch (Exception e) {
                event.getTextChannel().sendMessage(Embedener.wrapMessageInEmbed(Constants.rollText, "Roll Description")).queue();
            }

        }
        if (Pattern.matches("(/\\d+d\\d+)", event.getMessage().getContent())) {
            int x, y = 0;
            String rollo = event.getMessage().getContent();
            int indexD = event.getMessage().getContent().indexOf('d');
            String rolloY = rollo.substring(indexD + 1);
            String rolloX = rollo.substring(1, indexD);
            try {
                x = Integer.valueOf(rolloX);
                y = Integer.valueOf(rolloY);
                DnDRoller dnd = new DnDRoller(x, y);
                dnd.roll(event);
            } catch (Exception e) {
                event.getTextChannel().sendMessage(Embedener.wrapMessageInEmbed(Constants.rollText, "Roll Description")).queue();
            }
        }
//MODULE TO TROLL IZO--------
        if (Constants.TROLL){
            if (351854867779813378L == Long.valueOf(event.getAuthor().getId())) {
                event.getTextChannel().sendMessage("<@173045484569493504>, your waifu, <@351854867779813378>, belongs in the :toilet:").queue();
            }
        }
        if(message.equals("/disable the comment")){
                Constants.TROLL = false;
        }
//---------------------------
        if (message.startsWith("/postit")) {
            String command = event.getMessage().getContent();
            try {
      //          String[] brokenDown = command.split("`");
     //           event.getTextChannel().sendMessage(Embedener.wrapMessageInEmbed(brokenDown[2], brokenDown[1])).queue();
                String[] prebrokenDown = command.split("}");
                event.getTextChannel().sendMessage(Embedener.wrapMessageInEmbedBETA(prebrokenDown[0], prebrokenDown[1], event)).queue();
            }catch (Exception e) {event.getTextChannel().sendMessage(Embedener.wrapMessageInEmbedBETA(command, "#796988", event)).queue();}
        }
        if (message.startsWith("/embed")) {
            String command = event.getMessage().getContent();
            String[] brokenDown = command.split("}");
            try {
                event.getTextChannel().sendMessage(Embedener.DescriptionEmbed(brokenDown[0], event, brokenDown[1])).queue();
            } catch (Exception e) {
                event.getTextChannel().sendMessage(Embedener.DescriptionEmbed(command,  event,"#796988")).queue();
            }
        }
    }
}