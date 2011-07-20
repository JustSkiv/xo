import com.sun.xml.internal.fastinfoset.util.StringArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: skiv
 * Date: 16.06.11
 * Time: 4:23
 * To change this template use File | Settings | File Templates.
 */
public class View extends JFrame implements ActionListener {
  final String PLAYER_LABEL = "Х";
  final String AI_LABEL = "O";
  final String NEUTRAL_LABEL = "O";
  JButton[] b = new JButton[9];

  public View() {
    Controller controller = new Controller();

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 1));

    add(panel);
    for (int i = 0; i < 9; i++) {
      b[i] = new JButton(NEUTRAL_LABEL);
      b[i].addActionListener(this);
      b[i].setActionCommand(Integer.toString(i));
      panel.add(b[i]);
    }
    panel.setVisible(true);
    setVisible(true);
    setSize(200, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent actionEvent) {
    //определяем, какая кнопка была нажата
    String command = actionEvent.getActionCommand();
    Integer buttonNumber = Integer.valueOf(command);
    b[buttonNumber].setText("X");
    b[buttonNumber].setEnabled(false);

    //формируем массив, для представления о текущей ситуации на поле
    Integer i = 0;
    String[] buttons = new String[9];
    for (JButton button : b) {
      buttons[i] = button.getText();
      i++;
    }

    //скармливаем наш массив контроллеру, который определяет победу / выигрыш.
    //либо возвращает номер клетки, в которую решил сделать ход компьютер
    int step = Controller.step(buttons);
    switch (step) {
      case Controller.PLAYER_WIN:
        // do win
        break;
      case Controller.PLAYER_LOSE:
        // do lose
        break;
      default:
        b[step].setText(AI_LABEL);
        b[step].setEnabled(false);
    }

  }
}
