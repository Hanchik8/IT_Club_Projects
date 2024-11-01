import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DrawArea extends JComponent {

   // image in which we're going to draw
   private BufferedImage image;
   // graphics2D object ==> used to draw on
   private Graphics2D g2;
   // mouse coordinates
   private int currentX, currentY, oldX, oldY;

   public DrawArea() {
      setDoubleBuffered(false);
      addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            // save coord x,y when mouse is pressed
            oldX = e.getX();
            oldY = e.getY();
         }
      });

      addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseDragged(MouseEvent e) {
            // coord x,y when drag mouse
            currentX = e.getX();
            currentY = e.getY();

            if (g2 != null) {
               // draw line if g2 context not null
               g2.drawLine(oldX, oldY, currentX, currentY);
               // refresh draw area to repaint
               repaint();
               // store current coords x,y as olds x,y
               oldX = currentX;
               oldY = currentY;
            }
         }
      });
   }

   public void saveImage() {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setDialogTitle("Save Image");

      // set the default file extension
      fileChooser.setSelectedFile(new File("drawing.png"));

      int userSelection = fileChooser.showSaveDialog(null);
      if (userSelection == JFileChooser.APPROVE_OPTION) {
         File fileToSave = fileChooser.getSelectedFile();
         try {
            // сохраняет файл в опред. формате (тут png)
            ImageIO.write(image, "PNG", fileToSave);
            System.out.println("Image saved successfully to: " + fileToSave.getAbsolutePath());
         } catch (IOException ex) {
            ex.printStackTrace();
         }
      }
   }

   protected void paintComponent(Graphics g) {
      if (image == null) {
         // image to draw null ==> we create
         image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
         g2 = (Graphics2D) image.getGraphics();
         // enable antialiasing
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         // clear draw area
         clear();
      }

      g.drawImage(image, 0, 0, null);
   }

   // now we create exposed methods
   public void clear() {
      g2.setPaint(Color.white);
      // draw white on entire draw area to clear
      g2.fillRect(0, 0, getSize().width, getSize().height);
      g2.setPaint(Color.black);
      repaint();
   }

   public void red() {
      g2.setPaint(Color.red);
   }

   public void black() {
      g2.setPaint(Color.black);
   }

   public void pink() {
      g2.setPaint(Color.magenta);
   }

   public void green() {
      g2.setPaint(Color.green);
   }

   public void blue() {
      g2.setPaint(Color.blue);
   }

}