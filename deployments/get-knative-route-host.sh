#!/bin/bash
export HOST_URL=$(kubectl get route $1 --output jsonpath='{.status.domain}')
echo $HOST_URL