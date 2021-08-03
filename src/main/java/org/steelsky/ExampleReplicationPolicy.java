package org.steelsky;

import org.apache.kafka.connect.mirror.DefaultReplicationPolicy;

import java.util.Map;

public class ExampleReplicationPolicy extends DefaultReplicationPolicy {

    private final Map<String, String> oldLocalTopicToNewRemoteTopic;

    public ExampleReplicationPolicy() {
        oldLocalTopicToNewRemoteTopic = Map.of("old_topic_1", "entirely-different-topic-name",
                                               "old_topic_2", "yet-another-very-different-name");
    }

    @Override
    public String formatRemoteTopic(String sourceClusterAlias, String topic) {
        if (oldLocalTopicToNewRemoteTopic.containsKey(topic)) {
            return oldLocalTopicToNewRemoteTopic.get(topic);
        }
        else {
            //If it's a new local topic that we don't need to arbitrarily rename, fallback to default renaming policy
            return super.formatRemoteTopic(sourceClusterAlias, topic);
        }
    }
}
