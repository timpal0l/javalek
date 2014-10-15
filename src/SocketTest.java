import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	static String dator = "xx.xxx.xx.xxx";
	static String line;

	static int port = 1337;

	public static void main(String[] args) throws IOException {
		startServer();
		startClient();
	}

	/* Client */
	public static void startClient() {
		(new Thread() {
			@Override
			public void run() {
				try {
					@SuppressWarnings("resource")
					Socket s = new Socket(dator, port);
					BufferedWriter out = new BufferedWriter(
							new OutputStreamWriter(s.getOutputStream()));
					int i = 2;
					while (true) {
						out.write("Du har " + i * i * i + " glassar i munnen");
						out.newLine();
						out.flush();
						i++;
						System.out.println(i);
						// Thread.sleep(1000);
					}

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	/* Server */
	public static void startServer() {
		(new Thread() {
			@Override
			public void run() {
				ServerSocket ss;
				try {
					ss = new ServerSocket(port);
					Socket s = ss.accept();
					BufferedReader in = new BufferedReader(
							new InputStreamReader(s.getInputStream()));

					while ((line = in.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}