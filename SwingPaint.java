
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingPaint {

   JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, pinkBtn, saveBtn;
   DrawArea drawArea;

   ActionListener actionListener = new ActionListener() {

      public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()) {
            case "Clear":
               drawArea.clear();
               break;
            case "Save":
               drawArea.clear();
               break;
            case "Black":
               drawArea.black();
               break;
            case "Blue":
               drawArea.blue();
               break;
            case "Green":
               drawArea.green();
               break;
            case "Red":
               drawArea.red();
               break;
            case "Pink":
               drawArea.pink();
               break;
            default:
               System.out.println("Unknown action");
         }
      }
   };

   public static void main(String[] args) {
      new SwingPaint().show();
   }

   public void show() {
      // create main frame
      JFrame frame = new JFrame("Swing Paint");
      Container content = frame.getContentPane();
      // set layout on content pane
      content.setLayout(new BorderLayout());
      // create draw area
      drawArea = new DrawArea();

      // add to content pane
      content.add(drawArea, BorderLayout.CENTER);

      // create controls to apply colors and call clear feature
      JPanel controls = new JPanel();

      clearBtn = new JButton("Clear");
      clearBtn.addActionListener(actionListener);
      saveBtn = new JButton("Save");
      saveBtn.addActionListener(e -> drawArea.saveImage()); // сalls saveImage() in DrawArea
      frame.add(saveBtn, BorderLayout.SOUTH);
      blackBtn = new JButton("Black");
      blackBtn.addActionListener(actionListener);
      blueBtn = new JButton("Blue");
      blueBtn.addActionListener(actionListener);
      greenBtn = new JButton("Green");
      greenBtn.addActionListener(actionListener);
      redBtn = new JButton("Red");
      redBtn.addActionListener(actionListener);
      pinkBtn = new JButton("Pink");
      pinkBtn.addActionListener(actionListener);

      // add to panel
      controls.add(greenBtn);
      controls.add(blueBtn);
      controls.add(blackBtn);
      controls.add(redBtn);
      controls.add(pinkBtn);
      controls.add(clearBtn);

      // add to content pane
      content.add(controls, BorderLayout.NORTH);

      frame.setSize(600, 600);
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Dimension dimention = toolkit.getScreenSize();
      frame.setBounds(dimention.width / 2 - 400, dimention.height / 2 - 300, 800, 550);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

}