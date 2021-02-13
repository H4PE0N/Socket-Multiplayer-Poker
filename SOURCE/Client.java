
import java.io.*;
import java.net.*;

// System.out.printf("[CLIENT]: \n");

public class Client
{
  public Client(String serverAddress, int serverPort) throws Exception
  {
    this.setServerAddress(serverAddress);
    this.setServerPort(serverPort);
    System.out.printf("[CLIENT]: CREATED CLIENT OBJECT: (%s, %d)\n", this.serverAddress, this.serverPort);
  }

  public int serverPort;

  public int getServerPort() throws Exception
  {
    System.out.printf("[CLIENT]: RETURNING SERVER PORT: (%d)\n", this.serverPort);
    return this.serverPort;
  }

  public void setServerPort(int serverPort) throws Exception
  {
    this.serverPort = serverPort;
    System.out.printf("[CLIENT]: UPDATED SERVER PORT: (%d)\n", this.serverPort);
  }



  public String serverAddress;

  public String getServerAddress() throws Exception
  {
    System.out.printf("[CLIENT]: RETURNING SERVER ADDRESS: (%s)\n", this.serverAddress);
    return this.serverAddress;
  }

  public void setServerAddress(String serverAddress) throws Exception
  {
    this.serverAddress = serverAddress;
    System.out.printf("[CLIENT]: UPDATED SERVER ADDRESS: (%s)\n", this.serverAddress);
  }



  public Socket clientSocket;

  public Socket getClientSocket() throws Exception
  {
    System.out.printf("[CLIENT]: RETURNING CLIENT SOCKET...\n");
    return this.clientSocket;
  }

  public void setClientSocket(Socket clientSocket) throws Exception
  {
    this.clientSocket = clientSocket;
    System.out.printf("[CLIENT]: UPDATED CLIENT SOCKET...\n");
  }



  public void startServerConnection() throws Exception
  {
    this.setClientSocket(new Socket(this.serverAddress, this.serverPort));
    System.out.printf("[CLIENT]: CONNECTED TO SERVER: (%s, %d)\n", this.serverAddress, this.serverPort);
  }



  public ObjectOutputStream outputStream;

  public void setOutputStream(ObjectOutputStream outputStream) throws Exception
  {
    this.outputStream = outputStream;
    System.out.printf("[CLIENT]: UPDATED OUTPUT STREAM...\n");
  }

  public ObjectOutputStream getOutputStream() throws Exception
  {
    System.out.printf("[CLIENT]: RETURNING OUTPUT STREAM...\n");
    return this.outputStream;
  }

  public ObjectInputStream inputStream;

  public void setInputStream(ObjectInputStream inputStream) throws Exception
  {
    this.inputStream = inputStream;
    System.out.printf("[CLIENT]: UPDATED INPUT STREAM...\n");
  }

  public ObjectInputStream getInputStream() throws Exception
  {
    System.out.printf("[CLIENT]: RETURNING INPUT STREAM...\n");
    return this.inputStream;
  }



  public ServerInfo reciveServerInfo() throws Exception
  {
    this.setInputStream(new ObjectInputStream(this.clientSocket.getInputStream()));
    ServerInfo info = (ServerInfo) this.inputStream.readObject();
    System.out.printf("[CLIENT]: RECIVED INFO FROM SERVER...\n");
    return info;
  }

  public void sendServerString(String string) throws Exception
  {
    this.setOutputStream(new ObjectOutputStream(this.clientSocket.getOutputStream()));
    this.outputStream.writeObject(string);
  }



  public void closeServerConnection() throws Exception
  {
    //this.outputStream.close();
    this.clientSocket.close();
    System.out.printf("[CLIENT]: CLOSED SERVER CONNECION: (%s, %d)\n", this.serverAddress, this.serverPort);
  }
}
