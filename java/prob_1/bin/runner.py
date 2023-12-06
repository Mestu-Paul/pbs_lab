import os

os.chdir("src")
os.system("javac Calculator.java")
os.system("javac CalculatorImpl.java")
os.system("javac Server.java")
os.system("javac Client.java")
os.system("java Server")
