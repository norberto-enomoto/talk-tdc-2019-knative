#!/bin/bash
echo "Calling endpoint Host:"${HOST_URL}" http://"${IP_ADDRESS}
curl -H "Host: ${HOST_URL}" http://${IP_ADDRESS}