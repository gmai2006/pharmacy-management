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

import java.util.List;
import org.apache.kafka.clients.admin.NewTopic;

public class KafkaManager {
    private static KafkaProducerService producer;
    private static KafkaConsumerService consumer;
    private static KafkaTopicAdmin admin;

    public static synchronized void init(String bootstrapServers, List<String> topics) {
        if (producer == null) {
            producer = new KafkaProducerService(bootstrapServers);
        }
        if (consumer == null) {
            consumer = new KafkaConsumerService(bootstrapServers, topics, "pharmacy");
            new Thread(consumer).start();
        }
        if (admin == null) {
            admin =
                    new KafkaTopicAdmin(
                            bootstrapServers,
                            topics.stream()
                                    .map(topic -> new NewTopic(topic, 1, (short) 1))
                                    .toList());
        }
    }

    public static KafkaProducerService getProducer() {
        return producer;
    }

    public static KafkaConsumerService getConsumer() {
        return consumer;
    }

    public static KafkaTopicAdmin getAdmin() {
        return admin;
    }

    public static void shutdown() {
        if (consumer != null) consumer.shutdown();
        if (producer != null) producer.close();
        if (admin != null) admin.close();
    }
}
