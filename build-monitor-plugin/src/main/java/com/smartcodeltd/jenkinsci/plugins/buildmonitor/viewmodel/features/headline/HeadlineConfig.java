package com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.features.headline;

/**
 * @author Jan Molak
 */
public class HeadlineConfig {
    public final boolean displayCommitters;
    public final boolean highlightStaleBuilds;
    public final int staleIfOlderThan;

    public HeadlineConfig(boolean displayCommitters, boolean highlightStaleBuilds, int staleIfOlderThan) {
        this.displayCommitters = displayCommitters;
        this.highlightStaleBuilds = highlightStaleBuilds;
        this.staleIfOlderThan = staleIfOlderThan;
    }
}
