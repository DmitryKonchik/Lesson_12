import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HardTask {
    static void findInformation(String text) {
        findEmails(text);
        findDocuments(text);
        findTel(text);
    }

    static void findDocuments(String text) {
        Pattern documentNumber = Pattern.compile("\\d{4}-\\d{4}-\\d{2}");
        Matcher matcherDocuments = documentNumber.matcher(text);
        ArrayList<String> listOfDocuments = new ArrayList<>();
        while (matcherDocuments.find()) {
            listOfDocuments.add(matcherDocuments.group());
        }
        System.out.println("Document number: " + listOfDocuments);
    }

    static void findTel(String text) {
        // Если в начале ругулярнного выражения стоит \\b, оно не видит первый номер телефона из примера,
        // если убрать и оставить только в конце, все видит, почему так может быть?
        // Если перед вторым номером поставить пробел так же происходит.
        // Без \\b все работает
        Pattern tel = Pattern.compile("\\b\\+\\([0-9]{2}\\)[0-9]{7}\\b");
        Matcher matcherTel = tel.matcher(text);
        ArrayList<String> listOfTel = new ArrayList<>();
        while (matcherTel.find()) {
            listOfTel.add(matcherTel.group());
        }
        System.out.println("Telephone numbers: " + listOfTel);
    }

    static void findEmails(String text) {
        Pattern email = Pattern.compile("\\b[A-z\\d._%+-]+@[A-z]+\\.[a-z]{2,}\\b");
        Matcher matcherEmail = email.matcher(text);
        ArrayList<String> listOfEmails = new ArrayList<>();
        while (matcherEmail.find()) {
            listOfEmails.add(matcherEmail.group());
        }
        System.out.println("Emails: " + listOfEmails);
    }
}
