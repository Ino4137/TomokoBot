import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LoadGun {
    static Random ran = new Random(6);
    static int bulletNum;

    int reload() {
       bulletNum = ran.nextInt(6);
       return bulletNum;
    }
}
