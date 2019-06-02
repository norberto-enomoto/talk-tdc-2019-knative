echo "Setting environments"
export CLUSTER_NAME=standard-cluster-2
export CLUSTER_ZONE=us-central1-a
export PROJECT=knative-project
export PROJECT_ID=$(gcloud config get-value core/project)
export PROJECT_ACCOUNT=$(gcloud config get-value core/account)