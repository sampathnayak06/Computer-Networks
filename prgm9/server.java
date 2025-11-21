import java.net.*;
import java.util.*;
public class DatagramSocketServer {
    public static void main(String []args)throws Exception
    {
        Scanner in=new Scanner(System.in);
        DatagramSocket servSocket=new DatagramSocket(9000);
        byte[] receiveData=new byte[1024];
        byte[] sendData=new byte[1024];
        System.out.println("****Server Side****");
        DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
        servSocket.receive(receivePacket);
        System.out.println(new String(receivePacket.getData()));
        InetAddress IPAddress=receivePacket.getAddress();
        int Port=receivePacket.getPort();
        while(true)
        {
            System.out.println("Type some messages to display on client end");
            String msg=in.nextLine();
            sendData=msg.getBytes();
            System.out.println("Messages sent from the server:"+new String(sendData));
            DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,Port);
            servSocket.send(sendPacket);
        }
    }
}
