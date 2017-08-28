#!/bin/bash
echo "========================================"
echo "====== Tear Down Docker containers ====="
echo "========================================"

set -e

all=$(docker ps -a -q --no-trunc --filter name=^/grd_selenium)

if [ "${all}" ]; then
  docker stop ${all}
  docker rm ${all}
fi