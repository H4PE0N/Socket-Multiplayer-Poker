
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ServerClient
{
  public Socket socket;
  public String username;

  public ServerClient(Socket socket, String username)
  {
    this.socket = socket;
    this.username = username;
  }
}
