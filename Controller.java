import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: skiv
 * Date: 16.06.11
 * Time: 4:26
 * To change this template use File | Settings | File Templates.
 */
public class Controller {
  static int dangerButton;
  public static final int PLAYER_WIN = -1;
  public static final int PLAYER_LOSE = -2;


  public static int step(String[] buttons) {
    if (isPlayerWin(buttons)) {
      System.out.println("Win!!!");//пользователь победил
      return PLAYER_WIN;
    }

    dangerButton = lookForHazards(buttons);
    if (dangerButton != -1) {
      System.out.println("Danger!!!");//предотвращаем победу пользователя на слелующем шаге
      return dangerButton;
    }
    return -1;
  }

  public static boolean isPlayerWin(String[] buttons) {
    Boolean[] vertWin = new Boolean[3], horWin = new Boolean[3], diagWin = new Boolean[2];

    //определяем выигрышные положения

    //по горизонтали:
    horWin[0] = buttons[0].equals(buttons[1]) && buttons[1].equals(buttons[2]);
    horWin[1] = buttons[3].equals(buttons[4]) && buttons[4].equals(buttons[5]);
    horWin[2] = buttons[6].equals(buttons[7]) && buttons[7].equals(buttons[8]);

    //по вертикали
    vertWin[0] = buttons[0].equals(buttons[3]) && buttons[3].equals(buttons[6]);
    vertWin[1] = buttons[1].equals(buttons[4]) && buttons[4].equals(buttons[7]);
    vertWin[2] = buttons[2].equals(buttons[5]) && buttons[5].equals(buttons[8]);

    //по диагонали
    diagWin[0] = buttons[0].equals(buttons[4]) && buttons[4].equals(buttons[8]);
    diagWin[1] = buttons[2].equals(buttons[4]) && buttons[4].equals(buttons[6]);

    if (horWin[0] || horWin[1] || horWin[2]) {
      if (buttons[0].equals("X"))
        return true;
    }
    return false;
  }

  public static Integer lookForHazards(String[] buttons) {
    //Поиск опасных ситуаций. То есть, ситуацй, когда следующий ход пользователя может стать выигрышным
    String tmp_button;
    for (int i = 0; i < 9; i++) {
      tmp_button = buttons[i];
      buttons[i] = "X";
      if (isPlayerWin(buttons))
        return i;
      buttons[i] = tmp_button;
    }
    return -1;
  }
}
