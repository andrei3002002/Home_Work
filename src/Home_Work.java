

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




}