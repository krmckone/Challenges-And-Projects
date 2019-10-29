import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;;

public class NameGenerator {

    static ArrayList<String> lastNames = readFile("../name_data/dist.all.last");
    static ArrayList<String> femaleNames = readFile("../name_data/dist.female.first");
    static ArrayList<String> maleNames = readFile("../name_data/dist.male.first");
    static Random random = new Random();

    public static void main(String[] args) {
        String firstName = getRandomFirstName("female");
        String lastName = getRandomLastName();
        String firstLetterFirstName = firstName.substring(0, 1);
        String restFirstName = firstName.substring(1);
        String firstLetterLastName = lastName.substring(0, 1);
        String restLastName = lastName.substring(1);

        System.out.println("Random name: " + firstLetterFirstName + restFirstName.toLowerCase() + " "
                + firstLetterLastName + restLastName.toLowerCase());
    }

    public static ArrayList<String> readFile(String filePath) {
        File file = new File(filePath);
        BufferedReader reader;
        try {
            String line;
            ArrayList<String> nameList = new ArrayList<String>();
            reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            while ((line = reader.readLine()) != null) {
                String[] splitString = line.split("( )+");
                String name = splitString[0];
                nameList.add(name);
            }
            reader.close();
            return nameList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<String>();
        }
    }

    public static String getRandomFirstName(String gender) {
        if (gender == "male") {
            return maleNames.get(random.nextInt(maleNames.size()));
        } else if (gender == "female") {
            return femaleNames.get(random.nextInt(femaleNames.size()));
        } else {
            return "";
        }
    }

    public static String getRandomLastName() {
        return lastNames.get(random.nextInt(lastNames.size()));
    }
}