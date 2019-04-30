package p1;
import java.net.*;
 

public class UDPReceiver2
{
	String lineFin;
	static String line1="";
	String ext1;
	String type;
	
	DatagramSocket ds = null;
	DatagramPacket dp = null;
	
	public UDPReceiver2()
	{
		System.out.println("In const");
		try
		{
			byte data[]= new byte[1024];
			ds= new DatagramSocket(1098);
			dp= new DatagramPacket(data,data.length);
							

//			}
	
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	
	}
	
	public void writeFunc(){
		try{
			String line=null;
	//		while(true)
	//		{
			for(int i=0; i<2; i++){
				ds.receive(dp);
				line= new String(dp.getData(),0,dp.getLength());
				if(line.equals(".xml")||line.equals(".txt")||line.equals(".json")||line.equals(".csv")||line.equals("form"))
				{
					System.out.println("In func");
					FileDetails.setExtension(line);
					System.out.println(FileDetails.getExtension());
					break;
				}
				else
				{
					FileDetails.setContent(line);
					System.out.println(FileDetails.getContent());
				}
			}
		}catch(Exception e){
			
		}

	}

	
}