package test.detector;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Detector {
	private static void keepTomcatAlive() throws NullPointerException {
		String s;
		java.io.BufferedReader in;

		System.setProperty("sun.net.client.defaultConnectTimeout", "8000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");

		try {
			URL url = new URL("http://localhost:8880/boting/wap");
			URLConnection con = url.openConnection();
			in = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
			con.setConnectTimeout(1000);
			con.setReadTimeout(4000);
			while ((s = in.readLine()) != null) {
				if (s.length() > 0) {
					return;
				}
			}
			in.close();
		} catch (Exception ex) {
		}
		
		startTomcat();
	}

	public static void stopTomcat() {
		try {
			java.lang.Process p = java.lang.Runtime.getRuntime().exec("cmd.exe /c start G://git//apiTestDemo//apiTestDemo//src//main//java//test//detector//stop.bat");
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
			String s;
			String t = "Stopping";
			boolean restart = false;
			while ((s = in.readLine()) != null) {
				if (s.indexOf(t) != -1) {
					restart = true;
					break;
				}
			}
			System.out.println("<" + new Date() + "> Tomcat is stop " + (restart ? "OK" : "ERROR"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void startTomcat() {
		try {
			java.lang.Process p = java.lang.Runtime.getRuntime().exec("cmd.exe /c start G://git//apiTestDemo//apiTestDemo//src//main//java//test//detector//start.bat");
//			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
//			String s;
//			String t = "Starting";
//			boolean restart = false;
//			while ((s = in.readLine()) != null) {
//				if (s.indexOf(t) != -1) {
//					restart = true;
//					break;
//				}
//			}
//			System.out.println("<" + new Date() + "> Tomcat is start " + (restart ? "OK" : "ERROR"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void debug(String msg) {
		System.out.println("Debug::: " + msg);
	}

	public static void main(String[] args) throws IOException {
//		while (true) {
//			try {
//				debug("Detect agin <" + new Date() + ">");
//				Detector.keepTomcatAlive();
//				debug("Sleep...");
//				Thread.sleep(5000);
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		}
		
	        Runtime rt = Runtime.getRuntime();  
	        Process p = null;  
	        try {  
	            rt.exec("cmd.exe /C start wmic process where name='cmd.exe' call terminate");  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	}
}
