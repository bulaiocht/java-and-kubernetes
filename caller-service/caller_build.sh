#!/bin/bash
gradle clean build
docker build -t caller-service:v1 .