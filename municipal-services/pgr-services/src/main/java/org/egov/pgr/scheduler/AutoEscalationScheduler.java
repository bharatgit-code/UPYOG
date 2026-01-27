package org.egov.pgr.scheduler;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutoEscalationScheduler {
    private static final Logger LOG = LogManager.getLogger(AutoEscalationScheduler.class);

    // Runs every minute
    //@Scheduled(cron = "0 * * * * *")
    // Runs every day at 00:01 (12:01 AM)
    @Scheduled(cron = "0 1 0 * * *")
    public void runAutoEscalationTask() {
        StopWatch watcher = StopWatch.createStarted();
        LOG.info("Daily auto escalation scheduled task started at 00:01");

        // Your business logic here
        watcher.stop();
        LOG.info("Daily auto escalation scheduled task execution time in MS: {}", watcher.getTime());

    }
}
