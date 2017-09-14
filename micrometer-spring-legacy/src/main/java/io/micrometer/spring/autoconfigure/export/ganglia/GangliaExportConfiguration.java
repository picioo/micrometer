/**
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.spring.autoconfigure.export.ganglia;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.util.HierarchicalNameMapper;
import io.micrometer.ganglia.GangliaConfig;
import io.micrometer.ganglia.GangliaMeterRegistry;
import io.micrometer.spring.autoconfigure.export.MetricsExporter;
import io.micrometer.spring.autoconfigure.export.StringToDurationConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration for exporting metrics to Ganglia.
 *
 * @author Jon Schneider
 */
@Configuration
@ConditionalOnClass(GangliaMeterRegistry.class)
@Import(StringToDurationConverter.class)
@EnableConfigurationProperties(GangliaProperties.class)
public class GangliaExportConfiguration {

    @Bean
    @ConditionalOnProperty(value = "spring.metrics.ganglia.enabled", matchIfMissing = true)
    public MetricsExporter gangliaExporter(GangliaConfig config,
                                           HierarchicalNameMapper nameMapper, Clock clock) {
        return () -> new GangliaMeterRegistry(config, nameMapper, clock);
    }

    @Bean
    @ConditionalOnMissingBean
    public Clock clock() {
        return Clock.SYSTEM;
    }

    @Bean
    @ConditionalOnMissingBean
    public HierarchicalNameMapper hierarchicalNameMapper() {
        return HierarchicalNameMapper.DEFAULT;
    }

}