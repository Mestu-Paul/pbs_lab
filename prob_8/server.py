import socket

# Server configuration
HOST = '127.0.0.1'  # Loopback IP address for local testing
PORT = 8080  # Port number

# Create a UDP socket object
server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Bind the socket to the host and port
server.bind((HOST, PORT))

print("Server is listening...")

# Receive data from clients
while True:
    data, client_address = server.recvfrom(1024)  # Maximum buffer size is 1024 bytes
    print(f"Received message from {client_address}: {data.decode('utf-8')}")

    # Optionally, send a response back to the client
    response = "Message received!"
    server.sendto(response.encode('utf-8'), client_address)
