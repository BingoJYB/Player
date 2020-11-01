#!/bin/bash

mvn clean
mvn package
java -jar target/player-0.0.1.jar