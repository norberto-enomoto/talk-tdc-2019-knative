#!/bin/bash
HOST_URL="service-v2.default.example.com"
echo "Calling endpoint Host:"${HOST_URL}" http://"${IP_ADDRESS}
curl -H "Host: ${HOST_URL}" http://${IP_ADDRESS}