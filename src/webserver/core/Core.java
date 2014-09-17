/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver.core;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import webserver.util.Util;

/**
 *
 * @author hudson.sales
 */
public class Core {

    public Core() {
        ServerSocket listenSocket;
        try {
            listenSocket = new ServerSocket(80);
            System.out.println("Server started...");
            System.out.println("Listening on port 80...");
            while (true) {
                String requestMessageLine;
                String fileName;

                Socket connectionSocket = listenSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                requestMessageLine = inFromClient.readLine();

                System.out.println(requestMessageLine);
                StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);

                if (tokenizedLine.nextToken().equals("GET")) {
                    fileName = tokenizedLine.nextToken();
                    if (fileName.equalsIgnoreCase("/")) {
                        fileName = "index.html";
                    } else if (fileName.startsWith("/")) {
                        fileName = fileName.substring(1);
                    }

                    File file = new File(Util.getWWWPath() + "/" + fileName);
                    if (file.exists()) {
                        int numOfBytes = (int) file.length();
                        FileInputStream inFile = new FileInputStream(Util.getWWWPath() + "/" + fileName);
                        byte[] fileInBytes = new byte[numOfBytes];
                        inFile.read(fileInBytes);
                        outToClient.writeBytes("HTTP/1.0 200 Document Follows\r\n");

                        if (fileName.endsWith(".jpg")) {
                            outToClient.writeBytes("Content-Type:image/jpeg\r\n");
                        }
                        if (fileName.endsWith(".gif")) {
                            outToClient.writeBytes("Content-Type:image/gif\r\n");
                        }
                        if (fileName.endsWith(".html")) {
                            outToClient.writeBytes("Content-Type:text/html\r\n");
                        }
                        if (fileName.endsWith(".ico")) {
                            outToClient.writeBytes("Content-Type:image/ico\r\n");
                        }

                        outToClient.writeBytes("Content-Length: " + numOfBytes + "\r\n");
                        outToClient.writeBytes("\r\n");
                        outToClient.write(fileInBytes, 0, numOfBytes);
                        connectionSocket.close();
                    } else {
                        File ferror = new File(Util.getError404Path());
                        int numOfBytes = (int) ferror.length();
                        FileInputStream inFile = new FileInputStream(Util.getError404Path());
                        byte[] fileInBytes = new byte[numOfBytes];
                        inFile.read(fileInBytes);
                        outToClient.writeBytes("HTTP/1.0 200 Document Follows\r\n");

                        if (fileName.endsWith(".ico")) {
                            outToClient.writeBytes("Content-Type:image/ico\r\n");
                        }

                        outToClient.writeBytes("Content-Type:text/html\r\n");
                        outToClient.writeBytes("Content-Length: " + numOfBytes + "\r\n");
                        outToClient.writeBytes("\r\n");
                        outToClient.write(fileInBytes, 0, numOfBytes);
                        connectionSocket.close();
                    }
                } else {
                    System.out.println("Bad Request Message");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}