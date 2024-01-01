import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 테마 선택 화면
 *
 * 생성 후 사용하기 전에 반드시 {@link #initialize} 메소드를 호출해야 한다.
 */
public class ThemeScreen {
    private JPanel panel1;
    private JButton buttonReturnButton;
    private JButton buttonWalkButton;
    private JButton buttonExerciseButton;
    private JButton buttonMealButton;
    private JButton buttonStudyButton;
    private JFrame frameMain;
    private MenuScreen menuScreen;
    private ThemeControl themeControl;

    /**
     * 기본 생성자
     */
    public ThemeScreen() {
    }

    /**
     * 화면을 보이게 한다.
     */
    public void show(){
        frameMain = new JFrame("THEME");
        frameMain.setContentPane(this.panel1);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setLocationRelativeTo(null);
        frameMain.setVisible(true);
        frameMain.setBounds(400,200,500,300);
    }

    /**
     * 의존성 주입을 위한 초기화 메소드
     * @param menuScreen
     * 메뉴 선택 화면
     * @param themeControl
     * 테마 선택 화면과 테마 지도 화면의 control
     */
    public void initialize(MenuScreen menuScreen, ThemeControl themeControl) {
        this.menuScreen = menuScreen;
        this.themeControl = themeControl;

        addListeners();
    }

    private void addListeners() {
        buttonReturnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                menuScreen.show();
            }
        });
        buttonExerciseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeControl.selectTheme(ThemeTag.Exercise);
            }
        });
        buttonMealButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeControl.selectTheme(ThemeTag.Meal);
            }
        });
        buttonStudyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeControl.selectTheme(ThemeTag.Study);
            }
        });
        buttonWalkButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeControl.selectTheme(ThemeTag.Walk);
            }
        });
    }
}