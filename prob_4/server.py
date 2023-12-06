import socket
import threading

# Server configuration
HOST = '127.0.0.1'  # Loopback IP address for local testing
PORT = 8080  # Port number

# Create a socket object
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Bind the socket to the host and port
server.bind((HOST, PORT))

# Listen for incoming connections (up to 5 clients)
server.listen(5)
print("Server is listening...")

# List to hold client connections
clients = []

# Function to handle incoming client connections
def handle_client_connection(client_socket):
    while True:
        # Receive data from the client
        data = client_socket.recv(1024).decode('utf-8')
        if not data:
            break
        
        print("Received Data: ",data)
        
        data_special = "You sent "+data
        data = "\n"+data+"\n"
        # Broadcast the received data to all other connected clients
        for c in clients:
            if c != client_socket:
                c.send(data.encode('utf-8'))
            else:
                c.send(data_special.encode('utf-8'))
    
    # Remove the disconnected client
    clients.remove(client_socket)
    client_socket.close()

# Accept incoming client connections
while True:
    client, address = server.accept()
    clients.append(client)

    # Create a thread to handle each client connection
    client_thread = threading.Thread(target=handle_client_connection, args=(client,))
    client_thread.start()
