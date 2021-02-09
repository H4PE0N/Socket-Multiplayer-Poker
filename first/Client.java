import java.net.*;
import java.io.*;
import java.util.*;

public class Client
{
  public static void main(String[] args) throws IOException
  {
    // CONNECTING TO SERVER
    Socket socket = new Socket("localhost", 5555);

    // SETTING UP RECIVING VARIABLES
    InputStreamReader input = new InputStreamReader(socket.getInputStream());
    BufferedReader buffered_reader = new BufferedReader(input);

    // SETTING UP SENDING VARIABLES
    PrintWriter print_writer = new PrintWriter(socket.getOutputStream());

    // INPUTING NAME
    Scanner scanner = new Scanner(System.in);
    System.out.printf("ENTER YOUR NAME: ");
    String name = scanner.nextLine();

    // SENDING MESSAGE TO SERVER
    print_writer.println(name);
    print_writer.flush();

    // RECIVING MESSAGE FROM SERVER
    String string = buffered_reader.readLine();
    System.out.printf("SERVER: %s\n", string);
  }
}
