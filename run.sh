#!/usr/bin/env sh

if [ -z $1 ];
then echo "Usage: ./run.sh <problem>";
exit
fi

javac $1/Main.java && java $1/Main input.txt
