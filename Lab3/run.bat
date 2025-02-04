@echo off
cd src || exit
javac GameOfLife\Grid.java Main\Main.java
java Main.Main
