import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: skiv
 * Date: 16.06.11
 * Time: 4:23
 * To change this template use File | Settings | File Templates.
 */
public class View extends JFrame{
  public View() {
    Controller controller = new Controller();
    System.out.println(controller.getTest("Skiv"));


    JPanel panel = new JPanel();
    JButton b1 = new JButton("test");

    add(panel);

    panel.add(b1);
    panel.setVisible(true);
    setVisible(true);
    pack();
  }
}
