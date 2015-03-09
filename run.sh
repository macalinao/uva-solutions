#!/usr/bin/env sh

if [ -z $1 ];
then echo "Usage: ./run.sh <problem>";
exit
fi

cd $1
javac Main.java && cat input.txt | java Main
