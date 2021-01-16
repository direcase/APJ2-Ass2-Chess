package com.example.APJ2_Ass2_Chess.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Chat  extends JPanel {// адрес сервера
        private static final String SERVER_HOST = "localhost";
        // порт
        private static final int SERVER_PORT = 3443;
        // клиентский сокет
        private Socket clientSocket;
        // входящее сообщение
        private Scanner inMessage;
        // исходящее сообщение
        private PrintWriter outMessage;
        // следующие поля отвечают за элементы формы
        private JTextField jtfMessage;
        private JTextField jtfName;
        private JTextArea jtaTextAreaMessage;
        // имя клиента
        private String clientName = "";
        // получаем имя клиента
        public String getClientName() {
            return this.clientName;
        }

    private BoxLayout layout;
    private JTextField input;
   private JTextField messages;
    public Chat() {
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        //Create message list
        try {
            // подключаемся к серверу
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBounds(600, 300, 600, 500);
        jtaTextAreaMessage = new JTextArea();
        jtaTextAreaMessage.setEditable(false);
        jtaTextAreaMessage.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jtaTextAreaMessage);
        add(jsp, BorderLayout.CENTER);
        // label, который будет отражать количество клиентов в чате
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Отправить");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);
        jtfMessage = new JTextField("Введите ваше сообщение: ");
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        // обработчик события нажатия кнопки отправки сообщения
        jbSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // если имя клиента, и сообщение непустые, то отправляем сообщение
                if (!jtfMessage.getText().trim().isEmpty()) {

                    sendMsg();
                    // фокус на текстовое поле с сообщением
                    jtfMessage.grabFocus();
                }

            }




        });

    }
    public void sendMsg() {
        // формируем сообщение для отправки на сервер
        String messageStr =  jtfMessage.getText();
        // отправляем сообщение
        outMessage.println(messageStr);
        outMessage.flush();
        jtfMessage.setText("");
    }

}