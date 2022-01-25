#!/usr/bin/env bash

source /home/ec2-user/.bashrc

export JAVA_OPTS=""
export SPRING_PROFILE="dev"

if [ -n "${APP_PROFILE}" ]
then
        echo "${APP_PROFILE} is not emprty"
        SPRING_PROFILE="${APP_PROFILE}"
fi

if [ "production" ==  "${APP_PROFILE}" ]
then
  export JAVA_OPTS=" $JAVA_OPTS -javaagent:/home/ec2-user/khan/khan-agent/khan-agent-5.1.0.jar"
  export JAVA_OPTS=" $JAVA_OPTS -Dkhan.config.file=khan-agent.conf"
  export JAVA_OPTS=" $JAVA_OPTS -noverify"
fi

cd /home/ec2-user/app
/home/ec2-user/.sdkman/candidates/java/current/bin/java -jar -Dserver.port=8080 \
    -Dspring.profiles.active="${SPRING_PROFILE}" \
    -Xmx1G -Xms1G \
    -XX:+UseG1GC  \
    $JAVA_OPTS \
    *.jar > /dev/null 2> /dev/null < /dev/null &