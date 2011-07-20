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
    Boolean horWin[] = new Boolean[10];
    horWin[0] = buttons[0].equals("X") && buttons[1].equals("X") && buttons[2].equals("X");

    if (horWin[0] || //по горизонтали
        (buttons[3].equals("X") && buttons[4].equals("X") && buttons[5].equals("X")) ||
        (buttons[6].equals("X") && buttons[7].equals("X") && buttons[8].equals("X")) ||

        (buttons[0].equals("X") && buttons[3].equals("X") && buttons[6].equals("X")) || //по вертикали
        (buttons[1].equals("X") && buttons[4].equals("X") && buttons[7].equals("X")) ||
        (buttons[2].equals("X") && buttons[5].equals("X") && buttons[8].equals("X")) ||

        (buttons[0].equals("X") && buttons[4].equals("X") && buttons[8].equals("X")) || //по диагонали
        (buttons[2].equals("X") && buttons[4].equals("X") && buttons[6].equals("X"))
        )
      return true;
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
