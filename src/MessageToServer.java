import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MessageToServer
{
    public static void init()
    {
        try
        {
            PrintWriter out = new PrintWriter(SomeRandomGameClient.serverSocket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                String msg = stdIn.readLine();
                out.println(SomeRandomGameClient.userName + ": " + msg);
        }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
