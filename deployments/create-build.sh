#!/bin/bash
sed "s/MY_GCP_PROJECT/$PROJECT_ID/g" yamls/build.yaml | kubectl apply --filename -