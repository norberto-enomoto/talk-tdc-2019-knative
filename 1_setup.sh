echo "Setting environments"
export CLUSTER_NAME=knative
export CLUSTER_ZONE=us-west1-c
export PROJECT=my-knative-project

echo "Creating google project" $PROJECT
gcloud projects create $PROJECT --set-as-default

echo "Enabling the necessaries APIs"
gcloud services enable cloudapis.googleapis.com container.googleapis.com containerregistry.googleapis.com