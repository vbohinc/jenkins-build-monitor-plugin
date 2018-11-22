package com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.features.highlight;

public class HighlightStaleBuildConfig {
    public final boolean highlightStaleBuilds;
    public final int staleIfOlderThan;

    public HighlightStaleBuildConfig(boolean highlightStaleBuilds, int staleIfOlderThan) {
        this.highlightStaleBuilds = highlightStaleBuilds;
        this.staleIfOlderThan = staleIfOlderThan;
    }
}
