import socket

# Client configuration
HOST = '127.0.0.1'  # Loopback IP address
PORT = 8080  # Port number

# Create a socket object
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect to the server
client.connect((HOST, PORT))


# Send data to the server
message = input("Enter message: ")
client.sendall(message.encode('utf-8'))

# Receive echoed message from the server
echoed_message = client.recv(1024).decode('utf-8')
print(f"Received echoed message: {echoed_message}")

client.close()
