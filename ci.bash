#!/bin/bash
DOCKER_USER='apkatransportowa'
DOCKER_PASS='vbOvRP0+1T62MQUZAs8AFxwhsgY4t8UP'
DOCKER_HOST='apkatransportowa.azurecr.io'
DOCKER_IMGNAME='apkatransportowa/transport-app:latest'
docker login --username=$DOCKER_USER --password=$DOCKER_PASS $DOCKER_HOST
docker push $DOCKER_IMGNAME

