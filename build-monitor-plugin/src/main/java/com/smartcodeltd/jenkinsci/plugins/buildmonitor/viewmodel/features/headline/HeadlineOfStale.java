package com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.features.headline;

import com.smartcodeltd.jenkinsci.plugins.buildmonitor.readability.Lister;
import com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.JobView;
import com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.duration.Duration;
import com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.duration.HumanReadableDuration;
import hudson.model.Result;

import static com.google.common.collect.Lists.newArrayList;

public class HeadlineOfStale implements CandidateHeadline {
    private final JobView job;
    private final HeadlineConfig config;
    private final Duration staleIfOlderThan;

    public HeadlineOfStale(JobView job, HeadlineConfig config) {
        this.job = job;
        this.config = config;
        //TODO make this time correct
        this.staleIfOlderThan = config.staleIfOlderThan > 0 ? new HumanReadableDuration(config.staleIfOlderThan * 1000 * 60) : null;
    }

    @Override
    public boolean isApplicableTo(JobView someJob) {
        return evaluate(someJob);
    }

    @Override
    public Headline asJson() {
        return new Headline(text());
    }

    private String text() {
        return Lister.describe(
            "STALE!!!",
            "STALE!!! Older than %s",
            newArrayList(staleIfOlderThan.value())
        );
    }

    private boolean evaluate(JobView job) {

        if (job.lastResult().equals(Result.NOT_BUILT)) {
            return false;
        }
        return config.highlightStaleBuilds && staleIfOlderThan != null && job.lastCompletedBuild().timeElapsedSince().greaterThan(staleIfOlderThan);

    }
}
