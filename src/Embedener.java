import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;


public class Embedener {
    public static MessageEmbed DescriptionEmbed (String message, MessageReceivedEvent event, String color) {
        String chopd = message.substring(6);
        EmbedBuilder eb = new EmbedBuilder();
        //       eb.setAuthor(Constants.EMBED_AUTHOR, Constants.EMBED_AUTHOR_URL, Constants.EMBED_AUTHOR_IMAGE);
        //       eb.setFooter(Constants.EMBED_FOOTER_NAME, Constants.EMBED_FOOTER_IMAGE);
        eb.setColor(Color.decode(color));
        eb.setDescription(message);
        eb.setDescription(chopd);
//        eb.addField("Test", "Izo is a fag", false);
        System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new java.util.Date()) + "] [CommandHandler] /embed | by: " + event.getAuthor().getName()+" ID: "+event.getAuthor().getId());
        return eb.build();
    }
    public static MessageEmbed wrapMessageInEmbed(String message, String title) {
        EmbedBuilder eb = new EmbedBuilder();
 //       eb.setAuthor(Constants.EMBED_AUTHOR, Constants.EMBED_AUTHOR_URL, Constants.EMBED_AUTHOR_IMAGE);
 //       eb.setFooter(Constants.EMBED_FOOTER_NAME, Constants.EMBED_FOOTER_IMAGE);
        eb.setColor(Color.decode("#796988"));
        eb.setDescription(message);
        eb.setTitle(title);
//        eb.addField("Test", "Izo is a fag", false);
        return eb.build();
    }

    public static MessageEmbed wrapMessageInEmbedBETA(String passedcontent, String color, MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        //       eb.setAuthor(Constants.EMBED_AUTHOR, Constants.EMBED_AUTHOR_URL, Constants.EMBED_AUTHOR_IMAGE);
        //       eb.setFooter(Constants.EMBED_FOOTER_NAME, Constants.EMBED_FOOTER_IMAGE);
        try {
            eb.setColor(Color.decode(color));
        }catch(Exception e){eb.setColor(Color.decode("#796988"));}

        String[] content1 = passedcontent.split("!");
        for(int x = 0; x<content1.length; x++) {
            if (x > 0) {
                String temp = content1[x];
                String[] temper = temp.split("_");
                try {
                    eb.addField(temper[0], temper[1], false);
                }catch(Exception e) {
                    try{
                        eb.addField(temper[0], "", false);
                    }catch (Exception e1){System.out.println(Arrays.toString(e1.getStackTrace()));}
                }
            }
        }
        System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new java.util.Date()) + "] [CommandHandler] /postit | by: " + event.getAuthor().getName()+" ID: "+event.getAuthor().getId());
        return eb.build();
    }
}
