import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Home_Work {

  // Расширьте программу `Task2MonthsEnums`.
  //
  // Добавьте ещё один `enum`, который будет описывать времена года (зима, лето, весна, осень).
  //
  // Для введённого пользователем месяца напишите, к какому именно времени года относится
  // выбранный месяц.

  private static final String sep = ",";

  private enum Month {
    JANUARY, // 0
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER,
  }

  private enum Season { // в единственном числе, без -s!
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
  }

  public static void main(String[] args) throws IOException {
    Map<Month, Integer> readMonth = readMonth("res/month.csv");

    Scanner scanner = new Scanner(System.in);
    Month parseMonth = parseMonth(scanner);
    String month = parseMonth.toString();
    Month monthKey = Month.valueOf(month.toUpperCase());
    System.out.println("\t" + monthKey + " is a part of the " + getSeason(monthKey) + " season.\n");
    System.out.println("Have a nice day");


  }

  //Method
  private static Season getSeason(Month month) {
    return switch (month) {
      case DECEMBER, JANUARY, FEBRUARY -> Season.WINTER;
      case MARCH, APRIL, MAY -> Season.SPRING;
      case JUNE, JULY, AUGUST -> Season.SUMMER;
      case SEPTEMBER, OCTOBER, NOVEMBER -> Season.AUTUMN;
    };
  }

  private static Map<Month, Integer> readMonth(String fileName) throws IOException {
    Map<Month, Integer> daysPerMonth = new HashMap<>();
    Scanner fileInput = new Scanner(new File(fileName));
    while (fileInput.hasNext()) {
      ;
      String line = fileInput.nextLine();
      int sepIndex = line.indexOf(sep);
      if (sepIndex != -1) {
        ;
        String monStr = line.substring(0, sepIndex);
        String dayStr = line.substring(sepIndex + 1);
        Month month = Month.valueOf(monStr);
        int days = Integer.parseInt(dayStr);
        daysPerMonth.put(month, days);
      }
    }
    fileInput.close();
    return daysPerMonth;
  }

  private static Month parseMonth(Scanner scanner) {

    for (int i = 0; i < Month.values().length; ++i) {
      // (i + 1) - индекс превратили в номер
      System.out.println((i + 1) + ". " + Month.values()[i]);
    }
    System.out.print("Enter the month in number: ");
    int answer = scanner.nextInt();
    scanner.nextLine(); // пропускаем остаток строки
    System.out.println();
    // если ввели число меньше 1 или больше размера - выбран некорректный пункт
    while (answer < 1 || answer > Month.values().length) {
      System.out.println("Please enter a valid value!");
      answer = scanner.nextInt();
      scanner.nextLine(); // пропускаем остаток строки
    }
    // (answer - 1) - номер превратили в индекс
    return Month.values()[answer - 1];
  }
}
