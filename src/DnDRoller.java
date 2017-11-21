import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DnDRoller {
    int mode;
    int times=1;
    int sum=0;
    int timesInit=1;
    String rollsWorked;

    DnDRoller(int X, int Y) {
        mode = Y+1;
        times = X;
        timesInit = X;
    }
    DnDRoller(int Y) {
        mode = Y;
    }


    public void roll(MessageReceivedEvent event) {
        ArrayList<Integer> rolls = new ArrayList<>();
        do {
            int randomNum = ThreadLocalRandom.current().nextInt(1, mode);
            Integer.toString(randomNum);
            rolls.add(randomNum);
            times--;
        }while (times>0);

        for(int roll : rolls){
            sum += roll;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(rolls));
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        rollsWorked = sb.toString();

        event.getTextChannel().sendMessage(Embedener.wrapMessageInEmbed( "Your shitty rolls: " + rollsWorked + " = " + sum, String.valueOf(timesInit + ":game_die: [1-" + --mode + "]"))).queue();
    }
}