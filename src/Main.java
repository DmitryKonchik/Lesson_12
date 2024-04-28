import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        returnAbbreviations(str);

    }

    static ArrayList<String> returnAbbreviations(String text) {
        ArrayList<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(" [A-ZА-Я]{2,6} ");
        Matcher matcher = p.matcher(text);
        while (matcher.find()) {
            list.add(matcher.group().trim());
        }
        // выводим все абревиатуры для проверки
        for (String str: list) {
            System.out.println(str);
        }
        return list;
    }
}