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
package io.micrometer.spring.autoconfigure.export;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * Base {@link ConfigurationProperties} class for configuring a metrics registry.
 *
 * @author Jon Schneider
 * @author Andy Wilkinson
 */
public abstract class RegistryProperties {

    private final Properties properties = new Properties();

    protected abstract String prefix();

    public String get(String key) {
        return this.properties.getProperty(key);
    }

    protected void set(String key, Object value) {
        this.properties.put(prefix() + "." + key, value.toString());
    }

}