import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 이미지를 표시하는 JPanel
 */
public class ImagePanel extends JPanel{
    private BufferedImage image;

    /**
     * 생성자.
     * @param pathname
     * 이미지 파일 경로
     */
    public ImagePanel(String pathname) {
       try {
          image = ImageIO.read(new File(pathname));
       } catch (IOException ex) {
       }
    }

    /**
     * 이미지의 너비를 px 단위로 반환한다.
     * @return
     * 이미지의 너비
     */
    public int getWidth() {
        return image.getWidth();
    }

    /**
     * 이미지의 높이를 px 단위로 반환한다.
     * @return
     * 이미지의 높이
     */
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}