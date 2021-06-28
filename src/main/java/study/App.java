package study;

import java.awt.*;

public class App{
    public static void main( String[] args ){
        EventQueue.invokeLater(() ->{
            FileReaderUI fileReaderUI = new FileReaderUI();
            fileReaderUI.setVisible(true);
        });
    }
}
