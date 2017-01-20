package com.jiangjian.study.java.net;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public class InterruptibleSocketTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new InterruptibleSocketFrame();
                frame.setTitle("Interruptible Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class InterruptibleSocketFrame extends JFrame {
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 60;

    private Scanner in;
    private JButton  interruptibleButton;
    private JButton blockingButton;
    private JButton cancelButton;
    private JTextArea message;
    private TestServer server;
    private Thread connectThread;

    public InterruptibleSocketFrame() {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);

        message = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(message));

        interruptibleButton = new JButton("Interruptible");
        blockingButton = new JButton("Blocking");
        northPanel.add(interruptibleButton);
        northPanel.add(blockingButton);

        interruptibleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interruptibleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            connectInterruptibly();
                        }catch (IOException e) {
                            message.append("\nInterruptibleSocketTest.connectInteruptibly:" + e);
                        }
                    }
                });
                connectThread.start();
            }
        });

        blockingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interruptibleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            connectBlocking();
                        }catch (IOException e) {
                             message.append("\nInterruptibleSocketTest.connectBlocking:" + e);
                        }
                    }
                });
                connectThread.start();
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        northPanel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectThread.interrupt();
                cancelButton.setEnabled(false);
            }
        });

        server = new TestServer();
        new Thread(server).start();
        pack();
    }

    public void connectInterruptibly() throws IOException{
        message.append("Interruptible:\n");
        try( SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189)))
        {
            in = new Scanner(channel);
            while(!Thread.currentThread().isInterrupted()) {
                message.append("Reading");
                if(in.hasNextLine()) {
                    String line = in.nextLine();
                    message.append(line);
                    message.append("\n");
                }
            }
        }finally {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    message.append("Chanel closed\n");
                    interruptibleButton.setEnabled(true);
                    blockingButton.setEnabled(true);
                }
            });
        }
    }

    public void connectBlocking() throws IOException{
        message.append("Blocking:\n");
        try(Socket socket = new Socket("localhost", 8189))
        {
            in = new Scanner(socket.getInputStream()) ;
            while(!Thread.currentThread().isInterrupted()) {
                message.append("Reading");
                if(in.hasNextLine()) {
                    String line = in.nextLine();
                    message.append(line);
                    message.append("\n");
                }
            }
        }finally {
            message.append("Socket closed\n");
            interruptibleButton.setEnabled(true);
            blockingButton.setEnabled(true);
        }
    }
}

class TestServer implements Runnable{

    @Override
    public void run() {
        try {
            ServerSocket s = new ServerSocket(8189);
            while(true) {
                Socket incoming = s.accept();
                Runnable r = new TestServerHandler(incoming);
                Thread t = new Thread(r);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TestServerHandler implements Runnable{
    private Socket incoming;
    private int counter;

    public TestServerHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = incoming.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            while(counter < 100) {
                counter++;
                if(counter <= 10) out.println(counter);
                Thread.sleep(100);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                incoming.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
