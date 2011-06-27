import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: skiv
 * Date: 16.06.11
 * Time: 4:26
 * To change this template use File | Settings | File Templates.
 */
public class Controller implements ActionListener{
  public String getTest(String str){
    return str + " test";
  }

  public void actionPerformed(ActionEvent actionEvent) {
    String s = actionEvent.toString();
    System.out.println("asd: " + s);
  }
}
