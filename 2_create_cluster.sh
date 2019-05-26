echo "Creating cluster"
gcloud beta container clusters create $CLUSTER_NAME --zone $CLUSTER_ZONE --no-enable-basic-auth --cluster-version "1.12.7-gke.10" --machine-type "n1-standard-4" --image-type "COS" --disk-type "pd-standard" --disk-size "100" --scopes "https://www.googleapis.com/auth/devstorage.read_only","https://www.googleapis.com/auth/logging.write","https://www.googleapis.com/auth/monitoring","https://www.googleapis.com/auth/servicecontrol","https://www.googleapis.com/auth/service.management.readonly","https://www.googleapis.com/auth/trace.append" --num-nodes "2" --enable-cloud-logging --enable-cloud-monitoring --no-enable-ip-alias --network "projects/knati-241817/global/networks/default" --subnetwork "projects/knati-241817/regions/us-central1/subnetworks/default" --addons HorizontalPodAutoscaling,HttpLoadBalancing,Istio --istio-config auth=MTLS_PERMISSIVE --enable-autoupgrade --enable-autorepair

echo "Grating cluster-admin permissions to the current user"
gcloud container clusters get-credentials standard-cluster-1 --zone us-central1-a --project $(gcloud config get-value core/project)
kubectl create clusterrolebinding cluster-admin-binding --clusterrole=cluster-admin --user=$(gcloud config get-value core/account)