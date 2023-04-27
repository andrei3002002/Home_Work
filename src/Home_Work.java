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
    FALL, // AUTUMN
  }


  //Method
  private static Season getSeason(Month month) {
    return switch (month) {
      case DECEMBER, JANUARY, FEBRUARY -> Season.WINTER;
      case MARCH, APRIL, MAY -> Season.SPRING;
      case JUNE, JULY, AUGUST -> Season.SUMMER;
      case SEPTEMBER, OCTOBER, NOVEMBER -> Season.FALL;
    };
  }

  private static final String sep = ",";

  public static void main(String[] args) throws IOException {
    Map<Month, Integer> readMonth = new HashMap<>();
    Scanner fileInput = new Scanner(new File("res/month.csv"));
    while (fileInput.hasNext()) {
      String line = fileInput.nextLine();
      int sepIndex = line.indexOf(sep);
      if (sepIndex != -1)
        ;
      String monthStr = line.substring(0, sepIndex);
      String daysStr = line.substring(sepIndex + 1);
      System.out.println(monthStr + " - " + daysStr);
    }
    fileInput.close();

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the month: ");
    String month = scanner.next();
    Month monthKey = Month.valueOf(month.toUpperCase());
    System.out.println(month + " is a part of the " + getSeason(monthKey) + " season.");

  }


}