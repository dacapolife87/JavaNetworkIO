package chap14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.omg.PortableInterceptor.TRANSPORT_RETRY;

public class SimpleChatClient {
	private static final String HOST = "localhost";
	private static final int PORT = 9090;
	
	private static FileHandler fileHandler;
	private Logger logger = Logger.getLogger("net.daum.javacafe");
	
	private Selector selector = null;
	private SocketChannel sc = null;
	
	private Charset charset = null;
	private CharsetDecoder decoder = null;
	
	public SimpleChatClient() {
		charset = Charset.forName("EUC-KR");
		decoder = charset.newDecoder();
	}
	
	public void initServer() {
		try {
			selector = Selector.open();
			
			sc = SocketChannel.open(new InetSocketAddress(HOST, PORT));
			
			sc.configureBlocking(false);
			
			sc.register(selector, SelectionKey.OP_READ);
		} catch (Exception e) {
			// TODO: handle exception
			log(Level.WARNING, "initServer()", e);
		}
	}
	
	public void startServer() {
		startWriter();
		startReader();
	}
	
	private void startWriter() {
		// TODO Auto-generated method stub
		info("Writer ");
		Thread t = new MyThread(sc);
		t.start();
	}

	private void startReader() {
		// TODO Auto-generated method stub
		info("reader start");
		
		try {
			while (true) {
				info("요청대기중");
				selector.select();
				
				Iterator it = selector.selectedKeys().iterator();
				
				while (it.hasNext()) {
					SelectionKey key = (SelectionKey) it.next();
					
					if (key.isReadable()) {
						read(key);
					}
					
					it.remove();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log(Level.WARNING, "startServer()", e);
		}
	}

	
	
	
	
	
	private void read(SelectionKey key) {
		// TODO Auto-generated method stub
		SocketChannel sc = (SocketChannel) key.channel();
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		
		int read = 0;
		
		try {
			read = sc.read(buffer);
			
			info(read + "byte를 읽었습니다");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				sc.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		buffer.flip();
		
		String data = "";
		
		try {
			data = decoder.decode(buffer).toString();
		} catch (Exception e) {
			// TODO: handle exception
			log(Level.WARNING, "read", e);
		}
		
		System.out.println("Message - "+data);
		
		clearBuffer(buffer);
		
	}

	private void clearBuffer(ByteBuffer buffer) {
		// TODO Auto-generated method stub
		if (buffer != null) {
			buffer.clear();
			buffer = null;
		}
	}
	
	////////////////LOG PART///////////////////////
	public void initLog() {
		// TODO Auto-generated method stub
		try {
			fileHandler = new FileHandler("SimpleChat.log");
		} catch (Exception e) {
			// TODO: handle exception
			logger.addHandler(fileHandler);
			logger.setLevel(Level.ALL);
		}
	}
	
	public void log(Level level, String msg, Exception e) {
		// TODO Auto-generated method stub
		logger.log(level, msg, e);
	}
	public void info(String msg) {
		logger.info(msg);
	}

	class MyThread extends Thread {
		private SocketChannel sc = null;
		public MyThread(SocketChannel sc) {
			this.sc =sc;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			
			try {
				while (!Thread.currentThread().isInterrupted()) {
					buffer.clear();
					BufferedReader in = new BufferedReader(
							new InputStreamReader(System.in));
					String message = in.readLine();
					if (message.equals("quit")
						|| message.equals("shutdown")){
						System.exit(0);
					}
					
					buffer.put(message.getBytes());
					buffer.flip();
					
					sc.write(buffer);
				}
			} catch (Exception e) {
				// TODO: handle exception
				log(Level.WARNING, "myThread.Run()", e);
			} finally {
				clearBuffer(buffer);
			}
		}
	}
	public static void main(String[] args) {
		SimpleChatClient scc = new SimpleChatClient();
		
		scc.initLog();
		scc.initServer();
		scc.startServer();
	}
}
