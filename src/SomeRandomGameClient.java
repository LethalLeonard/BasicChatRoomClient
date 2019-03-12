import com.sun.media.jfxmediaimpl.MetadataParserImpl;

import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SomeRandomGameClient
{
    public static String userName = "";
    public static Socket serverSocket;

    private static final ExecutorService serviceLoader = Executors.newFixedThreadPool(10);

    public static void main(String[] args)
    {
        String hostName = "69.249.243.52";
        int portNumber = 25565;

        System.out.print("Please enter a name: ");
        Scanner scan = new Scanner(System.in);
        userName = scan.next();

        try
        {
            serverSocket = new Socket(hostName, portNumber);
        } catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        serviceLoader.execute(() -> MessageFromServer.init());
        serviceLoader.execute(() -> MessageToServer.init());
    }

}
