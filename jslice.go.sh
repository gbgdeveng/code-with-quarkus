#!/bin/bash

set -e

log() {
    echo "$(date --utc "+%FT%T.000Z")" "$1"
}

if [[ -z "{{ env }}" ]]
then
    log "APP_ENV is required in order to start jslice"
    exit 1
fi

cd /opt/jslice
APP=code-with-quarkus
APPLOG=$(echo "$APP" | awk -F '.' '{print $1}')
[[ -z "$NAME_SUFFIX" ]] || APPLOG=${APPLOG}-${NAME_SUFFIX}

if [[ -z "$P_LOGGING" ]] || [[ "$P_LOGGING" = "true" ]]; then
    log "Starting remote_syslog"
    /usr/local/bin/remote_syslog --poll -c /etc/log_files_{{ env }}.yml
fi

log "Prepping log file"
log "Init - Hostname: $(hostname)" > /var/log/jslice/${APPLOG}.0.log

log "Starting log file to stdout"
tail -F /var/log/jslice/${APPLOG}.0.log &

log "Start ${APP}, env: {{ env }}, port: ${PORT}, applog: ${APPLOG}, lb: ${LOAD_BALANCER}, name_suffix: ${NAME_SUFFIX} cache_ttl: ${CACHE_TTL} cache_negative_ttl ${CACHE_NEGATIVE_TTL}"
log "Java Opts ${JAVA_OPTS}"

exec /opt/jslice/${APP} \
    -Dmode={{ env }} \
    -Dquarkus.http.host=0.0.0.0 \
    >> /var/log/jslice/${APPLOG}.0.log 2>&1