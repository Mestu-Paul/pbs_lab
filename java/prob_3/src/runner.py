import os

os.chdir("src")
os.system("javac Chatbot.java")
os.system("javac ChatbotImp.java")
os.system("javac Server.java")
os.system("javac Client.java")
os.system("java Server")
