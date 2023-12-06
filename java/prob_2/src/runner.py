import os

os.chdir("src")
os.system("javac TicTacToeService.java")
os.system("javac TicTacToeServiceImpl.java")
os.system("javac Server.java")
os.system("javac Client.java")
os.system("java Server")
