package com.sand.java.socket;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8081);
            DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            dataOutputStream.writeUTF(str);
            dataOutputStream.flush();
            dataOutputStream.close();
            s.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
