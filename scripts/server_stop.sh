#!/bin/bash

export APP_PID=`ps -ef | grep java | grep app.jar | awk -F' ' '{print $2}'`

kill $APP_PID

exit 0