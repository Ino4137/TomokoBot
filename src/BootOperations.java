import com.stack.overflow.works.model.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BootOperations implements Scannable {

    @Override
    public void scan(){
        File file = new File(Constants.FILE_NAME);
        Scanner scanner = null;

        Data data = null;
        try{
            scanner = new Scanner(file);
            while (scanner.hasNextLine()){

                String line = scanner.nextLine();
                String[] items = line.split(Constants.SEMICOLON);
                data = new Data();

                data.setUserID(Long.valueOf(items[0]));

                if(isInEnum(items[1], ELO.class)){
                    data.setElo(items[1]);
                }

                if(isInEnum(items[2], ROLES.class)){
                    data.setRole1(items[2]);
                }

                if(isInEnum(items[3], ROLES.class)){
                    data.setRole2(items[3]);
                }
                Constants.recordList.add(data);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if(e.name().equals(value)) { return true; }
        }
        return false;
    }
}
