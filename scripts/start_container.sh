#!/bin/bash
set -e

docker pull pavan539/sample-vote-app
docker run -d -p 8080:8080 pavan539/sample-vote-app