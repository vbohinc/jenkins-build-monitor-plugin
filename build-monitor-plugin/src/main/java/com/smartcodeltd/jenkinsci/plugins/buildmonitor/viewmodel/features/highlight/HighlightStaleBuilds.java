package com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.features.highlight;

import com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.BuildViewModel;
import com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.JobView;
import com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.duration.Duration;
import com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.features.Feature;
import org.codehaus.jackson.annotate.JsonProperty;

public class HighlightStaleBuilds implements Feature {
    private JobView job;
    private HighlightStaleBuildConfig config;

    public HighlightStaleBuilds(HighlightStaleBuildConfig config) {
        this.config = config;
    }

    @Override
    public HighlightStaleBuilds of(JobView jobView) {
        this.job = jobView;

        return this;
    }

    @Override
    public HighlightStaleBuilds.HighlightStaleBuild asJson() {
        return new HighlightStaleBuild(job.lastCompletedBuild());
    }

    private static String formatted(Duration duration) {
        return null != duration
            ? duration.value()
            : "";
    }

    public static class HighlightStaleBuild {
        private final BuildViewModel staleBuild;

        public HighlightStaleBuild(BuildViewModel lastCompletedBuild) {
            this.staleBuild = lastCompletedBuild;
        }

        @JsonProperty
        public final String name() {
            return staleBuild.name();
        }

        @JsonProperty
        public final String url() {
            return staleBuild.url();
        }

        @JsonProperty
        public final String duration() {
            return formatted(staleBuild.duration());
        }

        @JsonProperty
        public final String description() {
            return staleBuild.description();
        }

        @JsonProperty
        public final String timeElapsedSince() {
            return formatted(staleBuild.timeElapsedSince());
        }

        @JsonProperty
        public final boolean isStale() {
            return true;
        }
    }
}
