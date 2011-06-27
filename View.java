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
public class View extends JFrame implements ActionListener{
  String field_x = "X";
  String field_o = "O";
  String field_n = ".";
  public View() {
    Controller controller = new Controller();
    System.out.println(controller.getTest("Skiv"));


    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 1));
    JButton[] b = new JButton[9];

    add(panel);
    for (int i = 0; i < 9; i++) {
      b[i] = new JButton(field_n);
      b[i].addActionListener(this);
      b[i].setActionCommand("Command :" + Integer.toString(i));
      panel.add(b[i]);
    }
    panel.setVisible(true);
    setVisible(true);
    pack();
  }

  public void actionPerformed(ActionEvent actionEvent) {
    String str = actionEvent.getSource().toString();
    System.out.println(str);
  }
}
