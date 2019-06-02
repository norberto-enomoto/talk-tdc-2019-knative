PROJECT_ID=$(gcloud config get-value core/project)

echo "Creating GKE Service account"
gcloud iam service-accounts create knative-build --display-name "Knative Build"
gcloud projects add-iam-policy-binding $PROJECT_ID --member serviceAccount:knative-build@$PROJECT_ID.iam.gserviceaccount.com --role roles/storage.admin
gcloud iam service-accounts keys create knative-key.json --iam-account knative-build@$PROJECT_ID.iam.gserviceaccount.com

echo "Creating K8S Service account"
kubectl create secret generic knative-build-auth --type="kubernetes.io/basic-auth" --from-literal=username="_json_key" --from-file=password=knative-key.json
kubectl annotate secret knative-build-auth build.knative.dev/docker-0=https://gcr.io
kubectl apply -f yamls/service-account.yaml