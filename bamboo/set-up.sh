#!/bin/bash
echo "========================================"
echo "======= Set Up Docker containers ======="
echo "========================================"

set -e

chrome=grd_selenium_chrome
firefox=grd_selenium_firefox
chrome_image=selenium/standalone-chrome:3.4.0
ff_image=selenium/standalone-firefox:3.4.0

stop_container(){
    local name=$1

    if [ "`docker ps -a | grep $name`" ]; then
        echo "Stopping and removing $name docker container..."
        docker stop $name
        docker rm $name
        echo "$name docker container is stopped and removed"
    fi
}

stop_container $chrome
#stop_container $firefox

echo "==== Pulling Selenium docker containers ===="
docker pull $chrome_image
#docker pull $ff_image

echo "==== Starting docker containers with standalone Selenium ===="
#docker run --name $firefox -p 4446:4444 -d $ff_image
docker run --name $chrome -p 4447:4444 -d $chrome_image

echo "==== Waiting docker containers set up ===="
sleep 30

#echo "==== Logs for docker container $firefox ===="
#docker logs --tail=500 $firefox
echo "==== Logs for docker container $chrome ===="
docker logs --tail=500 $chrome