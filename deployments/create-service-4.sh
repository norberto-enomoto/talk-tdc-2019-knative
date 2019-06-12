#!/bin/bash
sed "s/MY_GCP_PROJECT/$PROJECT_ID/g" yamls/service_4.yaml | kubectl apply --filename -