#!/bin/bash
sed "s/MY_GCP_PROJECT/$PROJECT_ID/g" yamls/service_3.yaml | kubectl apply --filename -