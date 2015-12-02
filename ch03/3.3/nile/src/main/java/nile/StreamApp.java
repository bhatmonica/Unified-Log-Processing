package nile;

public class StreamApp {

  public static void main(String[] args) {
    String zookeeper = args[0];
    String brokers = args[1];
    String groupId = args[2];
    String inTopic = args[3];
    String outTopic = args[4];
    int numThreads = Integer.parseInt(args[5]);

    NileConsumerGroup consumerGroup = new NileConsumerGroup(
      zookeeper, groupId, inTopic, numThreads);
    NileProducer producer = new NileProducer(brokers, outTopic);
    consumerGroup.run(producer);
  }
}