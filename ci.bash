#!/bin/bash
DOCKER_USER='apkatransportowa'
DOCKER_PASS='g3vnSppserXKFaeqtOGmbG5qlfAb=jBj'
DOCKER_HOST='apkatransportowa.azurecr.io'
DOCKER_IMGNAME='apkatransportowa/transport-app'
docker login --username=$DOCKER_USER --password=$DOCKER_PASS $DOCKER_HOST
docker push $DOCKER_IMGNAME