#!/bin/bash
kubectl logs -f --selector serving.knative.dev/service=telegram-service -c user-container