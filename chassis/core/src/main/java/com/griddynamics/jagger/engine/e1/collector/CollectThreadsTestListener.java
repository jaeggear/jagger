package com.griddynamics.jagger.engine.e1.collector;

import com.griddynamics.jagger.engine.e1.Provider;
import com.griddynamics.jagger.engine.e1.collector.test.TestInfo;
import com.griddynamics.jagger.engine.e1.collector.test.TestListener;
import com.griddynamics.jagger.engine.e1.services.ServicesAware;

import static com.griddynamics.jagger.util.StandardMetricsNamesUtil.VIRTUAL_USERS;
import static com.griddynamics.jagger.util.StandardMetricsNamesUtil.VIRTUAL_USERS_ID;

/**
 * Listener, executed periodically during test to collect number of workload threads
 *
 * @author Gribov Kirill
 * @n
 * @par Details:
 * @details This listener allows to collect and store information about workload produced by Jagger @n
 * When listener is used it saves number of Jagger threads that produce workload for SUT. Later this data @n
 * is available in report and WebUI.
 *
 */
public class CollectThreadsTestListener extends ServicesAware implements Provider<TestListener> {

    /**
     * Method is executed single time when listener is created
     */
    @Override
    protected void init() {
        MetricDescription metricDescription = new MetricDescription(VIRTUAL_USERS_ID)
                .displayName(VIRTUAL_USERS)
                .plotData(true)
                .showSummary(true)
                .addAggregator(new AvgMetricAggregatorProvider());
        getMetricService().createMetric(metricDescription);
    }

    /**
     * Method is providing listener to Jagger that will trigger listener methods during test run
     */
    @Override
    public TestListener provide() {
        return new TestListener() {
            @Override
            public void onStart(TestInfo testInfo) {
            }

            @Override
            public void onStop(TestInfo testInfo) {
            }

            @Override
            public void onRun(TestInfo status) {
                getMetricService().saveValue(VIRTUAL_USERS_ID, status.getThreads());
            }
        };
    }
}
