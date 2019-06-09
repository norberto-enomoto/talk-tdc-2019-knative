#!/bin/bash
echo "Creating GKE Service account"
gcloud iam service-accounts create camel-k-builder --display-name "Camel-K Builder"
gcloud projects add-iam-policy-binding $PROJECT_ID --member serviceAccount:camel-k-builder@$PROJECT_ID.iam.gserviceaccount.com --role roles/storage.admin
gcloud iam service-accounts keys create kaniko-secret.json --iam-account camel-k-builder@$PROJECT_ID.iam.gserviceaccount.com

echo "Creating K8S Service account"
kubectl create secret generic kaniko-secret --from-file=kaniko-secret.json

echo "Removing kaniko-secret.json file"
rm kaniko-secret.json

echo "Installing Camel-K"
kamel install --registry gcr.io --organization $PROJECT_ID --push-secret kaniko-secret
kubectl apply -f yamls/camel.yaml
kubectl apply -f yamls/camel-source.yaml