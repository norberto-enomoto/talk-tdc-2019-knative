#!/bin/bash
while(true); do kubectl logs -f --selector serving.knative.dev/service=telegram-service -c user-container; done