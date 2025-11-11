/**
 * %% Copyright (C) 2025 DataScience 9 LLC %% Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License. #L%
 */
package com.datascience9.pharmacy.notification;

import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.errors.TopicExistsException;

public class KafkaTopicAdmin {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final AdminClient adminClient;

    public KafkaTopicAdmin(String bootstrapServers, List<NewTopic> topics) {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        this.adminClient = AdminClient.create(props);
        this.adminClient.createTopics(topics);
    }

    public Set<String> listTopics() {
        try {
            return adminClient.listTopics().names().get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to list topics", e);
        }
    }

    public void createTopic(String name, int partitions, short replicationFactor) {
        NewTopic newTopic = new NewTopic(name, partitions, replicationFactor);
        try {
            adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
            logger.info("[KafkaAdmin] Created topic: " + name);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof TopicExistsException) {
                logger.info("[KafkaAdmin] Topic already exists: " + name);
            } else {
                throw new RuntimeException("Failed to create topic " + name, e);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create topic " + name, e);
        }
    }

    public void deleteTopic(String name) {
        try {
            adminClient.deleteTopics(Collections.singletonList(name)).all().get();
            logger.info("[KafkaAdmin] Deleted topic: " + name);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete topic " + name, e);
        }
    }

    public void close() {
        adminClient.close();
    }
}
