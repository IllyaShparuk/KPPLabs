#!/bin/bash
mkdir -p out
javac -d out src/*/*.java
java -cp out Main.Main
