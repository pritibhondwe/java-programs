import java.io.*;
import java.net.*;
import java.util.*;

public class ChatApp {
    private static final int PORT = 1234;
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage:");
            System.out.println("  java ChatApp server   -> start server");
            System.out.println("  java ChatApp client   -> start client");
            return;
        }

        if (args[0].equalsIgnoreCase("server")) {
            startServer();
        } else if (args[0].equalsIgnoreCase("client")) {
            startClient();
        } else {
            System.out.println("Invalid argument. Use 'server' or 'client'.");
        }
    }

    // ---------------- SERVER ----------------
    private static void startServer() throws IOException {
        System.out.println("💬 Chat Server started on port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("✅ New client connected: " + clientSocket);
                new ClientHandler(clientSocket).start();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("📩 Received: " + message);
                    synchronized (clientWriters) {
                        for (PrintWriter writer : clientWriters) {
                            writer.println(message);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("⚠️ Client disconnected: " + socket);
            } finally {
                try { socket.close(); } catch (IOException ignored) {}
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            }
        }
    }

    // ---------------- CLIENT ----------------
    private static void startClient() throws IOException {
        try (Socket socket = new Socket("localhost", PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("✅ Connected to Chat Server");
            System.out.println("Type your messages...");

            // Thread to read server messages
            Thread readerThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("⚠️ Disconnected from server.");
                }
            });
            readerThread.start();

            // Send user input to server
            String userMessage;
            while ((userMessage = console.readLine()) != null) {
                out.println("Client says: " + userMessage);
            }
        }
    }
}
