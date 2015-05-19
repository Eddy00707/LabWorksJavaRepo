import java.io.*;
import java.util.Vector;

//public class ReadWrite implements Runnable{
//	private String path;
	//private Vector<Transport> collection;
//	private Boolean isWrite = false;
	
	//public ReadWrite(String path, Vector<Transport> collection, Boolean isWrite){
	//	this.path = path;
	//	this.collection= collection;
	//	this.isWrite = isWrite;
	//}
	
	//public void SaveCollection(){
	//	Writer writer = null;
    //    try {
     //       writer = new FileWriter(this.path);
     //       for (int i = 0; i<this.collection.size(); i++) {
     //       	writer.write("The "+(i+1)+" car in autopark: ");
     //       	writer.write("\n");
     //       	writer.write("Car made by: " + this.collection.elementAt(i).GetFirm());
    //        	writer.write("\n");
    //        	writer.write("Car type is: " + this.collection.elementAt(i).GetType());
    //        	writer.write("\n");
    //        	writer.write("Car number is: " + this.collection.elementAt(i).GetNumber());
    //        	writer.write("\n");
    //        	writer.write("Car course is: " + this.collection.elementAt(i).GetWay());
    //        	writer.write("\n");
    //        	writer.write("Car capacity is: " + this.collection.elementAt(i).GetCapacity());
    //        	writer.write("\n");
     //       	writer.write("Driver name is: " + this.collection.elementAt(i).GetDriver());
   //         	writer.write("\n");
  //          }
  //          writer.flush();
  //      } 
  //     catch (IOException  e) {
  //      	System.err.println(e);
   //     } 
    //    finally {
   //         if (writer != null) {
   //             try {
   //                 writer.close();
  //              } 
  //              catch (IOException ex) {
  //              }
 //           }
 //       }
//	}
	
//	public Vector<String> LoadCollection() throws FileNotFoundException, IOException{
 //       String line = null;
 //       Vector<String> lines = new Vector<String>();
 //       
 //       File file = new File(this.path);
//
 //       BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
 //       
 ///       while ((line = br.readLine()) != null) {
//        	lines.add(line);
 //       }
 //       br.close();
//		
//		return lines;
//	}

//	@Override
//	public void run(){
//		System.out.println("Override method run() calls. Saving works in separate thread.");
//		
//		if(this.isWrite){
//			this.SaveCollection();
//		}
	//}
//}
