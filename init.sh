#!/usr/bin/env sh

# Initializes a problem.

if [ -z $1 ];
then echo "Usage: ./init.sh <problem";
exit
fi

mkdir $1
touch $1/Main.java
touch $1/input.txt
touch $1/output.txt
printf "$1\n=====" > $1/README.md
