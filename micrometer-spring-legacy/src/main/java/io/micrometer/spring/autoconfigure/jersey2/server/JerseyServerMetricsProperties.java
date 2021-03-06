/**
 * Copyright 2017 Pivotal Software, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.spring.autoconfigure.jersey2.server;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration for Jersey server instrumentation.
 *
 * @author Michael Weirauch
 */
@ConfigurationProperties(prefix = "management.metrics.jersey2.server")
public class JerseyServerMetricsProperties {

    private boolean enabled = true;

    private String requestsMetricName = "http.server.requests";

    private boolean autoTimeRequests = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRequestsMetricName() {
        return requestsMetricName;
    }

    public void setRequestsMetricName(String requestsMetricName) {
        this.requestsMetricName = requestsMetricName;
    }

    public boolean isAutoTimeRequests() {
        return autoTimeRequests;
    }

    public void setAutoTimeRequests(boolean autoTimeRequests) {
        this.autoTimeRequests = autoTimeRequests;
    }
}
