#!/usr/bin/env sh
# Play in the terminal:   ./run.sh
# Run the tests:          ./run.sh test
# Needs a JDK (11+). Uses $JAVA_HOME if set.
cd "$(dirname "$0")"
BIN="${JAVA_HOME:+$JAVA_HOME/bin/}"
mkdir -p out
"${BIN}javac" -d out src/NumberGuessing.java test/NumberGuessingTest.java || exit 1
if [ "$1" = "test" ]; then exec "${BIN}java" -ea -cp out NumberGuessingTest; fi
exec "${BIN}java" -cp out NumberGuessing
