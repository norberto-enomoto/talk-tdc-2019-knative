#!/bin/bash
~/go/bin/hey -z 20s -c 100 -host "service.default.example.com" "http://${IP_ADDRESS}"