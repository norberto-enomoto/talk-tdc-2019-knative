#!/bin/bash
~/go/bin/hey -z 10s -c 500 -host "service.default.example.com" "http://${IP_ADDRESS}"