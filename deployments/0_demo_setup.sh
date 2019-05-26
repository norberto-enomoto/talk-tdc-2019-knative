echo "Getting Istio external IP"
export IP_ADDRESS=$(kubectl get svc istio-ingressgateway --namespace istio-system | awk '{if(NR>1)print $4}')
echo "Gotten Istio external IP" $IP_ADDRESS
