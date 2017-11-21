import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.ThreadLocalRandom;

public class RRoller {
    private static int COUNT;
    private static int POS;
    private LoadGun LG = new LoadGun();

    RRoller(String s, MessageReceivedEvent event){
        POS = LG.reload();
        COUNT = LG.reload();
        try{
        event.getTextChannel().sendMessage("Reloading the gun...").queue();
        COUNT = 0;
        }catch(Exception e){}
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch(Exception e){}
    }
    RRoller(){}

    public void roll(MessageReceivedEvent event) {

        String response = "";

        if (COUNT == POS){
            response += "Bullet goes straight through your head. You have successfully killed yourself <:tomoUnimpressed:352023454129717248>";
            System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new java.util.Date()) + "] [Info] " +event.getAuthor().getName()+" ID: "+event.getAuthor().getId()+" died.");
            POS = LG.reload();
            COUNT = 0;
        }
        else {
            COUNT++;
            response += "You grin, finding out that there was no bullet in the chamber.";
            System.out.println("[" + new SimpleDateFormat("HH.mm.ss").format(new java.util.Date()) + "] [Info] " +event.getAuthor().getName()+" ID: "+event.getAuthor().getId()+" survived.");
        }

        try {
            event.getTextChannel().sendMessage("There was no regret on your face. It's time to roll.").queue();
        }catch(Exception e){}
        try {
        TimeUnit.SECONDS.sleep(2);
        }catch(Exception e){}
        try {
        event.getTextChannel().sendMessage("You took a deep breath and pulled the trigger.").queue();
        }catch(Exception e){}
        try {
        TimeUnit.SECONDS.sleep(2);
        }catch(Exception e){}
        try {
        event.getTextChannel().sendMessage(response).queue();
        }catch(Exception e){}
    }
}
