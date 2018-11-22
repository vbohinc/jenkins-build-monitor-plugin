package com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.features.highlight;

public class HighlightStaleBuildConfig {
    public final boolean highlightStaleBuilds;
    public final int olderThan;

    public HighlightStaleBuildConfig(boolean highlightStaleBuilds, int olderThan) {
        this.highlightStaleBuilds = highlightStaleBuilds;
        this.olderThan = olderThan;
    }
}
