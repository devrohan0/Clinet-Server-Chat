/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat1017;

/**
 *
 * @author admin
 */


import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 3000);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            Scanner key = new Scanner(System.in);

            while (true) {
                System.out.print("Send/Receive/Quit: ");
                String input = key.next();

                switch (input.charAt(0)) {
                    case 's':
                    case 'S':
                        System.out.print("Enter message to send: ");
                        String messageToSend = key.next();
                        pw.println(messageToSend);
                        break;
                    case 'r':
                    case 'R':
                        String receivedMessage = br.readLine();
                        System.out.println("Received message: " + receivedMessage);
                        break;
                    case 'q':
                    case 'Q':
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
