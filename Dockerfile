FROM registry.access.redhat.com/ubi8/openjdk-21-runtime:1.20

ENV LANGUAGE='en_US:en'

# Copy the pre-built uber-jar (built by CI)
COPY --chown=185 build/libs/*-runner.jar /deployments/quarkus-run.jar

EXPOSE 8080
USER 185
ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]
