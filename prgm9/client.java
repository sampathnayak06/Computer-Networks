import java.net.*;
public class DatagramSocketClient {
    public static void main(String[] args)throws Exception
    {
        String line="Connected with client";
        DatagramSocket clientSock=new DatagramSocket();
        InetAddress IPAddress=InetAddress.getByName("localhost");
        byte[] sendData=new byte[1024];
        byte[] receiveData=new byte[1024];
        sendData=line.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9000);
        clientSock.send(sendPacket);
        System.out.println("******Client Terminal Display********");
        while(true)
        {
            DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
            clientSock.receive(receivePacket);
            String msgReceived=new String(receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());
            System.out.println("Message typed at server side is:"+msgReceived);
        }
    }
}
