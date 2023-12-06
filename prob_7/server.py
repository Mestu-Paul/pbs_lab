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

# Function to handle each client connection
def handle_client(client_socket, address):
    print(f"Connection from {address} has been established.")
    
    # Receive data from the client and echo it back
    while True:
        data = client_socket.recv(1024).decode('utf-8')
        if not data:
            break
        print(f"Received message from {address}: {data}")
        
        # Echo back the received message
        client_socket.sendall(data.encode('utf-8'))
    
    client_socket.close()

# Accept incoming connections and start handling clients concurrently
while True:
    client, address = server.accept()
    
    # Create a thread to handle each client connection
    client_thread = threading.Thread(target=handle_client, args=(client, address))
    client_thread.start()
