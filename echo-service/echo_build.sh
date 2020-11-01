#!/bin/bash
gradle clean build
docker build -t echo-service:v1 .