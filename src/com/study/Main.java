/*
Создать приложение с 3 потоками для следующей задачи:
		3 работника выполняют следующую работу:
			1-ый копает яму,
			2-ой сажает дерево,
			3-ий подвязывает саженец к кольям.
	Работа идет строго по очереди. Число саженцев задается параметром.
	Выводить на дисплей номер работника и номер саженца.
 */



package com.study;

import lab4.lab4_task;

import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame {

    private JTextField textField1;
    private static JTextArea textArea;

    private int n1 = 1;

    private int curLabNum = 1;

    public Main() {
        super("My last lab");
        setResizable(false);
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainpanel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        BoxLayout blo = new BoxLayout(mainpanel, BoxLayout.Y_AXIS);
        mainpanel.setLayout(blo);


        JLabel textLabel = new JLabel();
        textLabel.setText("Numbers:");
        panel2.add(textLabel);

        textField1 = new JTextField();
        textField1.setColumns(5);
        textField1.setText("0");
        panel2.add(textField1);


        JButton button5 = new JButton("Run");
        button5.addActionListener(e -> {
            try {
                switch (curLabNum){
                    case 1:
                        n1 = tryIntFromString(textField1.getText());
                        new lab4_task().run(n1);
                        break;
                }
            } catch (Exception e2){
                myPrint("Input error!");
            }
        });
        panel2.add(button5);

        textArea = new JTextArea();
        textArea.setColumns(25);
        textArea.setRows(20);
        textArea.setAutoscrolls(true);
        panel3.add(textArea);

        JScrollPane sp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel3.add(sp);

        mainpanel.add(panel1);
        mainpanel.add(panel2);
        mainpanel.add(panel3);

        getContentPane().add(mainpanel);

        setPreferredSize(new Dimension(350, 500));
    }

    private int tryIntFromString(String from){
        int tmp = 1;
        try {
            tmp = Integer.parseInt(from);
            if (tmp > 0)
                return tmp;
            else
                myPrint("Number must be more then zero!");
        } catch (Exception e2){
            myPrint("Input error!");
        }
        return tmp;
    }

    public static void myPrint(String text){
        textArea.setText(textArea.getText() + text + "\n");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            //JFrame.setDefaultLookAndFeelDecorated(true);
            Main frame = new Main();
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
