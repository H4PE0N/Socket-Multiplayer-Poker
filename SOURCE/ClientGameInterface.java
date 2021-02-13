
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.BorderLayout;

public class ClientGameInterface
{
  private static JFrame startMenuFrameObject = new JFrame();

  private static JPanel startMenuInputPanel = new JPanel();
  private static JPanel startMenuInfoPanel = new JPanel();
  private static JPanel startMenuButtonPanel = new JPanel();

  private static JTextField inputPanelUsernameInput;
  private static JLabel inputPanelUsernameLabel;

  private static JButton buttonPanelCloseButton;
  private static JButton buttonPanelStartButton;

  public static void main(String[] args)
  {
    ClientGameInterface clientInterface = new ClientGameInterface("ClientGameInterface");
  }

  public ClientGameInterface(String frameTitle)
  {
    configureStartMenuFrame(frameTitle);
    configureStartMenuButtonListeners();
    configureStartMenuPanels();
    startMenuFrameObject.setVisible(true);
  }

  private static void configureStartMenuPanels()
  {
    configureStartMenuInputPanel();
    configureStartMenuInfoPanel();
    configureStartMenuButtonPanel();
  }

  private static void configureStartMenuInputPanel()
  {
    startMenuInputPanel.setBackground(Color.WHITE);
    startMenuInputPanel.setBounds(10, 10, 500, 660);
    startMenuInputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    startMenuInputPanel.setLayout(null);

    inputPanelUsernameLabel = new JLabel("Username");
    inputPanelUsernameLabel.setBounds(10, 10, 200, 25);
    startMenuInputPanel.add(inputPanelUsernameLabel);

    inputPanelUsernameInput = new JTextField(200);
    inputPanelUsernameInput.setBounds(220, 10, 200, 25);
    startMenuInputPanel.add(inputPanelUsernameInput);

    startMenuFrameObject.add(startMenuInputPanel);
  }

  private static void configureStartMenuInfoPanel()
  {
    startMenuInfoPanel.setBackground(Color.WHITE);
    startMenuInfoPanel.setBounds(520, 10, 730, 500);
    startMenuInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    startMenuInfoPanel.setLayout(null);
    startMenuFrameObject.add(startMenuInfoPanel);
  }

  private static void configureStartMenuButtonPanel()
  {
    startMenuButtonPanel.setBackground(Color.WHITE);
    startMenuButtonPanel.setBounds(520, 520, 730, 150);
    startMenuButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    startMenuButtonPanel.setLayout(null);

    buttonPanelCloseButton = new JButton("CLOSE");
    buttonPanelCloseButton.setBounds(10, 10, 200, 130);

    buttonPanelStartButton

    startMenuFrameObject.add(startMenuButtonPanel);
  }

  private void configureStartMenuButtonListeners()
  {
    ActionListener closeButtonListener = new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
        System.out.println("CLOSE BUTTON CLICKED");
      }
    };

    ActionListener startButtonListener = new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
        System.out.println("START BUTTON CLICKED");
      }
    };
  }

  private static void configureStartMenuFrame(String frameTitle)
  {
    startMenuFrameObject.setSize(1280, 720);
    startMenuFrameObject.setTitle(frameTitle);
    startMenuFrameObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    startMenuFrameObject.getContentPane().setBackground(Color.LIGHT_GRAY);
    startMenuFrameObject.setResizable(false);
    startMenuFrameObject.setLayout(null);
  }
}
