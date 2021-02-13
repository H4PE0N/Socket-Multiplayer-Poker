
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

// System.out.printf("[SERVER]: \n");

public class Server
{
  public ArrayList<ServerClient> clients = new ArrayList<ServerClient>();
  public ServerSocket server;

  public Server(int port) throws Exception
  {
    this.server = new ServerSocket(port);
  }

  public String acceptConnectingClient() throws Exception
  {
    Socket socket = server.accept();
    String username = this.receiveSocketString(socket);
    this.clients.add(new ServerClient(socket, username));
    return username;
  }

  public void sendUsernameInformation(String username, ServerInfo information) throws Exception
  {
    Socket socket = this.getUsernameSocket(username);
    this.sendSocketInformation(socket, information);
  }

  public void sendSocketInformation(Socket socket, ServerInfo information) throws Exception
  {
    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
    outputStream.writeObject(information);
  }

  public Socket getUsernameSocket(String username)
  {
    for(ServerClient client : this.clients)
    {
      if(client.username.equals(username))
      {
        return client.socket;
      }
    }
    return null;
  }

  public String receiveUsernameString(String username) throws Exception
  {
    Socket socket = this.getUsernameSocket(username);
    return this.receiveSocketString(socket);
  }

  public String receiveSocketString(Socket socket) throws Exception
  {
    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
    return (String) inputStream.readObject();
  }
  // public Server(String serverAddress, int serverPort) throws Exception
  // {
  //   this.setServerAddress(serverAddress);
  //   this.setServerPort(serverPort);
  //   System.out.printf("[SERVER]: CREATED SERVER OBJECT: (%s, %d)\n", this.serverAddress, this.serverPort);
  // }
  //
  // public int serverPort;
  // public String serverAddress;
  // public ServerSocket serverSocket;
  // public ArrayList<Socket> clients = new ArrayList<Socket>();
  //
  // public int getServerPort() throws Exception
  // {
  //   System.out.printf("[SERVER]: RETURNING SERVER PORT: (%d)\n", this.serverPort);
  //   return this.serverPort;
  // }
  //
  // public void setServerPort(int serverPort) throws Exception
  // {
  //   this.serverPort = serverPort;
  //   System.out.printf("[SERVER]: UPDATED SERVER PORT: (%d)\n", this.serverPort);
  // }
  //
  //
  // public String getServerAddress() throws Exception
  // {
  //   System.out.printf("[SERVER]: RETURNING SERVER ADDRESS: (%s)\n", this.serverAddress);
  //   return this.serverAddress;
  // }
  //
  // public void setServerAddress(String serverAddress) throws Exception
  // {
  //   this.serverAddress = serverAddress;
  //   System.out.printf("[SERVER]: UPDATED SERVER ADDRESS: (%s)\n", this.serverAddress);
  // }
  //
  // public ServerSocket getServerSocket() throws Exception
  // {
  //   System.out.printf("[SERVER]: RETURNING SERVER SOCKET...\n");
  //   return this.serverSocket;
  // }
  //
  // public void setServerSocket(ServerSocket serverSocket) throws Exception
  // {
  //   this.serverSocket = serverSocket;
  //   System.out.printf("[SERVER]: UPDATED SERVER SOCKET...\n");
  // }
  //
  //
  //
  // public ObjectOutputStream socketOutputStream(Socket socket) throws Exception
  // {
  //   System.out.printf("[SERVER]: RETURNING SOCKET OUTPUT STREAM...\n");
  //   return new ObjectOutputStream(socket.getOutputStream());
  // }
  //
  // public ObjectInputStream socketInputStream(Socket socket) throws Exception
  // {
  //   System.out.printf("[SERVER]: RETURNING SOCKET INPUT STREAM...\n");
  //   return new ObjectInputStream(socket.getInputStream());
  // }
  //
  //
  //
  //
  //
  // public void sendClientInfo(Socket clientSocket, Information info) throws Exception
  // {
  //   ObjectOutputStream outputStream = socketOutputStream(clientSocket);
  //   outputStream.writeObject(info);
  //   System.out.printf("[SERVER]: SEND CLIENT INFO...\n");
  // }
  //
  // public Information reciveClientInfo(Socket clientSocket) throws Exception
  // {
  //   ObjectInputStream inputStream = socketInputStream(clientSocket);
  //   Information info = (Information) inputStream.readObject();
  //   System.out.printf("[SERVER]: RECIVED INFO FROM CLIENT...\n");
  //   return info;
  // }
  //
  // public String reciveClientString(Socket clientSocket) throws Exception
  // {
  //   ObjectInputStream inputStream = socketInputStream(clientSocket);
  //   String string = (String) inputStream.readObject();
  //   System.out.printf("[SERVER]: RECIVED STRING FROM CLIENT...\n");
  //   return string;
  // }
  //
  //
  // public void startServerSocket() throws Exception
  // {
  //   this.setServerSocket(new ServerSocket(this.serverPort));
  //   System.out.printf("[SERVER]: STARTED SERVER: (%s, %d)\n", this.serverAddress, this.serverPort);
  // }
  //
  // public void closeServerSocket() throws Exception
  // {
  //   this.serverSocket.close();
  //   System.out.printf("[SERVER]: CLOSED SERVER: (%s, %d)\n", this.serverAddress, this.serverPort);
  // }
  //
  //
  //
  // public Socket acceptConnectingClient() throws Exception
  // {
  //   Socket clientSocket = this.serverSocket.accept();
  //   System.out.printf("[SERVER]: ACCEPTED CONNECTING CLIENT...\n");
  //   return clientSocket;
  // }
  //
  //
  // public void closeClientConnection(Socket clientSocket) throws Exception
  // {
  //   clientSocket.close();
  //   System.out.printf("[SERVER]: STOPED CLIENT CONNECTION...\n");
  // }
}
