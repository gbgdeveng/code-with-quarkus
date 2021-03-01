#FROM registry.access.redhat.com/ubi8/ubi-minimal:8.3
#
#LABEL APP=code-with-quarkus
#
#ENV RUNNING_APP code-with-quarkus
#
#ARG RUNNING_ENV=dev
#ENV APP_ENV=${RUNNING_ENV}
#
#ARG PT_LOGGING=false
#ENV P_LOGGING=${PT_LOGGING}
#
#ADD *.go.sh /opt/jslice/
#ADD ./project/target/code-with-quarkus /opt/jslice/
#
#RUN microdnf install hostname && \
#    microdnf update -y && \
#    microdnf clean all && \
#    rm -rf /var/cache/yum && \
#    bash -c "mkdir -p /var/log/jslice /opt/jslice/{exploded,logs}" && \
#    bash -c "chmod -R 777 /opt/jslice /var/log/jslice" && \
#    chmod 775 /opt/jslice/code-with-quarkus

FROM registry.access.redhat.com/ubi8/ubi-minimal:8.3
WORKDIR /work/
RUN chown 1001 /work \
    && chmod "g+rwX" /work \
    && chown 1001:root /work
COPY --chown=1001:root target/*-runner /work/application

EXPOSE 8080
USER 1001

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]