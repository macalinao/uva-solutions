#!/usr/bin/env sh

if [ -z $1 ];
then echo "Usage: ./run.sh <problem>";
exit
fi

cd $1
javac Main.java && cat input.txt | java Main > /tmp/test

# Equality test
TEST=`cat /tmp/test`;
CORRECT=`cat output.txt`;
if [ "$TEST" != "$CORRECT" ]; then
  echo "Code is incorrect"
  vim -d /tmp/test output.txt
  exit 1
else
  echo "Code is correct!";
fi
