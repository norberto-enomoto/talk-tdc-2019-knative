#!/bin/bash
HOST_URL="service.default.example.com"
echo "Calling endpoint Host:"${HOST_URL}" http://"${IP_ADDRESS}
while(true); do curl -w "\n" -H "Host: ${HOST_URL}" http://${IP_ADDRESS}; done;