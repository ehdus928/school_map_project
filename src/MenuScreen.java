import javax.swing.*;
import java.awt.event.*;

/**
 * 메뉴 화면
 *
 * 생성 후 사용하기 전에 반드시 {@link #initialize} 메소드 호출해야 한다.
 */
public class MenuScreen {
    private JFrame frameMain;
    private JPanel panel1;
    private JButton buttonTheme;
    private JButton 편의시설Button;
    private JButton 사용자의견Button;
    private JButton buttonReturn;
    private LocationInputScreen locationInputScreen;
    private ThemeScreen themeScreen;

    /**
     * 기본 생성자
     */
    public MenuScreen() {
    }

    /**
     * 화면을 보이게 한다.
     */
    public void show(){
        frameMain = new JFrame("MENU");
        frameMain.setContentPane(this.panel1);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setLocationRelativeTo(null);
        frameMain.setVisible(true);
        frameMain.setBounds(400,200,500,300);
    }

    /**
     * 의존성 주입을 위한 초기화 메소드
     * @param locationInputScreen
     * 사용자 위치 입력 화면
     * @param themeScreen
     * 테마 선택 화면
     */
    public void initialize(LocationInputScreen locationInputScreen, ThemeScreen themeScreen) {
        this.locationInputScreen = locationInputScreen;
        this.themeScreen = themeScreen;

        addListeners();
    }

    private void addListeners() {
        buttonTheme.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeScreen.show();
            }
        });
        buttonReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                locationInputScreen.show();
            }
        });
    }
}
