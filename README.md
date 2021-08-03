###An example of how to arbitrarily rename topics being replicated to in MM2

1. Ensure the `mirror-connect-client` version matches that of the Mirror Maker 2 installation
2. Build the JAR
3. Ensure that the Kafka Connect (KC) worker property `plugin.path` is configured [(docs)](https://kafka.apache.org/documentation/#connectconfigs_plugin.path)
4. Copy JAR into the directory in the KC worker container/bare metal node that was configured above
5. Set the MM2 connector property `replication.policy.class` [(docs)](https://cwiki.apache.org/confluence/display/KAFKA/KIP-382%3A+MirrorMaker+2.0#KIP382:MirrorMaker2.0-ConnectorConfigurationProperties) to the fully qualified name of the custom replication policy, e.g., `org.steelsky.ExampleReplicationPolicy`
6. Test a canary topic first...