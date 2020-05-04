#!/usr/bin/env bash

nohup java -Dspring.profiles.active=prod -jar cms-*.jar > /dev/null &