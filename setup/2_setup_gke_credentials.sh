echo "Enabling the necessaries APIs"
gcloud services enable cloudapis.googleapis.com container.googleapis.com containerregistry.googleapis.com

echo "Grating cluster-admin permissions to the current user"
gcloud container clusters get-credentials $CLUSTER_NAME --zone $CLUSTER_ZONE --project $PROJECT_ID
kubectl create clusterrolebinding cluster-admin-binding --clusterrole=cluster-admin --user=$PROJECT_ACCOUNT