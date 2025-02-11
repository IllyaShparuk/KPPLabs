@echo off

if not exist out mkdir out
javac -d out src/GameOfLife/*.java src/Main/*.java
java -cp out Main.Main
