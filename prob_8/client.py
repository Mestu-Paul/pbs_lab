import socket

# Client configuration
HOST = '127.0.0.1'  # Loopback IP address
PORT = 8080  # Port number

# Create a UDP socket object
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Send data to the server
message = input("Enter message: ")
client.sendto(message.encode('utf-8'), (HOST, PORT))

# Receive response from the server
response, server_address = client.recvfrom(1024)  # Maximum buffer size is 1024 bytes
print(f"Received response from server: {response.decode('utf-8')}")

client.close()
