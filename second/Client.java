
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

  private int port;
  private Socket socket;
  private String address;
  private String name;

  private InputStreamReader input;
  private BufferedReader reader;
  private PrintWriter writer;

  public Client(String address, int port, String name) throws IOException
  {
    this.port = port;
    this.address = address;
    this.name = name;

    socket = new Socket(address, port);
    sendToServer(this.name);
  }

  public String reciveFromServer() throws IOException
  {
    input = new InputStreamReader(socket.getInputStream());
    reader = new BufferedReader(input);
    return reader.readLine();
  }

  public void sendToServer(String string) throws IOException
  {
    writer = new PrintWriter(socket.getOutputStream());
    writer.println(string);
    writer.flush();
  }
}
