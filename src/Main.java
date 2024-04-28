import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String str1 = "Номер телефона:+(44)1234999 \n" +
                "Электронная почта:  exam.p_le@example.com\n" +
                "Номер документа:  1234-5678-99, 1234-5678-90" +
                "ывпп+(33)3456777";

        HardTask.findInformation(str1);

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        returnAbbreviations(str);

    }

    static ArrayList<String> returnAbbreviations(String text) {
        ArrayList<String> list = new ArrayList<>();
        Pattern p = Pattern.compile("\\b[A-ZА-Я]{2,6}\\b");
        Matcher matcher = p.matcher(text);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        // выводим все аббревиатуры для проверки
        for (String str : list) {
            System.out.println(str);
        }
        return list;
    }
}