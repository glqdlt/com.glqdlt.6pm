#!/usr/bin/env bash

nohup java -Dspring.profiles.active=prod -jar web-cms-*.jar > /dev/null &