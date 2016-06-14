package chap14;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleChatServer {
	private static final String HOST = "localhost";
	private static final int PORT = 9090;
	
	private static FileHandler fileHandler;
	private Logger logger = Logger.getLogger("net.daum.javacafe");
	
	private Selector selector = null;
	private ServerSocketChannel serverSocketChannel = null;
	private ServerSocket serverSocket = null;
	
	private Vector room = new Vector();
	
	public void initServer(){
		try {
			selector = Selector.open();
			
			serverSocketChannel = ServerSocketChannel.open();
			
			serverSocketChannel.configureBlocking(false);
			
			serverSocket = serverSocketChannel.socket();
			
			InetSocketAddress isa = new InetSocketAddress(HOST, PORT);
			serverSocket.bind(isa);
			
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (Exception e) {
			// TODO: handle exception
			log(Level.WARNING,"SimpleChat",e);
		}
	}
	
	public void startServer(){
		info("Server is started");
		
		try {
			while (true) {
				info("요청기다리는중");
				
				selector.select();
				
				Iterator it = selector.selectedKeys().iterator();
				
				while (it.hasNext()) {
					SelectionKey key = (SelectionKey) it.next();
					
					if(key.isAcceptable()){
						accept(key);
					} else if (key.isReadable()) {
						read(key);
					}
					it.remove();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log(Level.WARNING, "simpleChatServer.StartServer()", e);
			
		}
	}
	
	private void accept(SelectionKey key){
		ServerSocketChannel server = (ServerSocketChannel) key.channel();
		
		SocketChannel sc;
		
		try {
			sc = server.accept();
			
			registerChannel(selector,sc,SelectionKey.OP_READ);
			info(sc.toString()+"클라이언트가 접속했습니다.");
			
		} catch (ClosedChannelException e) {
			// TODO: handle exception
			log(Level.WARNING, "accpet()", e);
		} catch (IOException e) {
			// TODO: handle exception
			log(Level.WARNING, "accpet()", e);
		}
	}
	
	
	private void registerChannel(Selector selector, SocketChannel sc,int ops) throws IOException{
		if (sc == null) {
			info("Invald connection");
			return;
		}
		sc.configureBlocking(false);
		sc.register(selector, ops);
		
		addUser(sc);
	}
	


	private void read(SelectionKey key) {
		SocketChannel sc = (SocketChannel) key.channel();
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		
		try {
			int read = sc.read(buffer);
			info(read + "byte를 읽었습니다");
		} catch (Exception e) {
			// TODO: handle exception
			try {
				sc.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			removeUser(sc);
			
			info(sc.toString() + "클라이언트가 접속을 해제했습니다.");
		}
		
		try {
			broadcast(buffer);
		} catch (Exception e) {
			// TODO: handle exception
			log(Level.WARNING, "broadcast()", e);
		}
		clearBuffer(buffer);
	}
	
	
	

	private void broadcast(ByteBuffer buffer) throws IOException{
		// TODO Auto-generated method stub
		buffer.flip();
		
		Iterator iter = room.iterator();
		while (iter.hasNext()) {
			SocketChannel sc = (SocketChannel) iter.next();
			
			if (sc != null) {
				sc.write(buffer);
				buffer.rewind();
			}
		}
	}

	private void clearBuffer(ByteBuffer buffer) {
		// TODO Auto-generated method stub
		if (buffer!=null) {
			buffer.clear();
			buffer = null;
		}
	}
	private void addUser(SocketChannel sc) {
		// TODO Auto-generated method stub
		room.add(sc);
	}

	private void removeUser(SocketChannel sc) {
		// TODO Auto-generated method stub
		room.remove(sc);
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
	
	public static void main(String[] args) {
		SimpleChatServer scs = new SimpleChatServer();
		scs.initLog();
		scs.initServer();
		scs.startServer();
	}
}
